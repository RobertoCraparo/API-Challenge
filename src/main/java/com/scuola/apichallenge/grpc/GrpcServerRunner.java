package com.scuola.apichallenge.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

// Gestisce il ciclo di vita del server gRPC associandolo al contesto di Spring.
@Component
public class GrpcServerRunner {

    private Server grpcServer;
    private final FilmGrpcServiceImpl filmGrpcService;

    // Inietta l'implementazione del servizio generata tramite Protobuf.
    public GrpcServerRunner(FilmGrpcServiceImpl filmGrpcService) {
        this.filmGrpcService = filmGrpcService;
    }

    // Inizializza e avvia il server sulla porta 9090 al termine dell'avvio dell'applicazione.
    @PostConstruct
    public void start() throws IOException {
        grpcServer = ServerBuilder.forPort(9090)
                .addService(filmGrpcService)
                .build()
                .start();
        System.out.println("Server gRPC in ascolto sulla porta 9090");
    }

    // Termina il processo gRPC in modo pulito allo spegnimento dell'applicazione.
    @PreDestroy
    public void stop() {
        if (grpcServer != null) {
            grpcServer.shutdown();
        }
    }
}