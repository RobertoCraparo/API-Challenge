package com.scuola.apichallenge.grpc;

import com.scuola.apichallenge.repository.FilmRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

// Implementazione del servizio gRPC generato tramite compilazione del file proto.
@Service
public class FilmGrpcServiceImpl extends FilmServiceGrpc.FilmServiceImplBase {

    private final FilmRepository repository;

    public FilmGrpcServiceImpl(FilmRepository repository) {
        this.repository = repository;
    }

    // Sovrascrittura del metodo definito nel contratto Protobuf.
    @Override
    public void getFilms(EmptyRequest request, StreamObserver<FilmListResponse> responseObserver) {
        FilmListResponse.Builder responseBuilder = FilmListResponse.newBuilder();

        repository.findAll().forEach(film -> {
            FilmMessage message = FilmMessage.newBuilder()
                    .setId(film.getId())
                    .setTitolo(film.getTitolo())
                    .setRegista(film.getRegista())
                    .setAnno(film.getAnno())
                    .build();
            responseBuilder.addFilms(message);
        });

        // Invio del payload al client e chiusura dello stream.
        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }
}