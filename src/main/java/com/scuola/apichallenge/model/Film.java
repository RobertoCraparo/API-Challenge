package com.scuola.apichallenge.model;

// Entità di dominio che rappresenta la risorsa scambiata tramite le API.
public class Film {
    private String id;
    private String titolo;
    private String regista;
    private int anno;

    // Costruttore vuoto richiesto per la deserializzazione JSON.
    public Film() {}

    public Film(String id, String titolo, String regista, int anno) {
        this.id = id;
        this.titolo = titolo;
        this.regista = regista;
        this.anno = anno;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitolo() { return titolo; }
    public void setTitolo(String titolo) { this.titolo = titolo; }
    public String getRegista() { return regista; }
    public void setRegista(String regista) { this.regista = regista; }
    public int getAnno() { return anno; }
    public void setAnno(int anno) { this.anno = anno; }
}