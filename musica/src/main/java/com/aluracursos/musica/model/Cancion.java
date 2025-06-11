package com.aluracursos.musica.model;

import jakarta.persistence.*;

@Entity
public class Cancion {

    @Id
    private Integer id;
    private String trackName;
    private String artistName;
    private String albumName;
    private Integer duration;

    public Cancion() {}

    public Cancion(DatosCancion datos) {
        this.id = datos.id();
        this.trackName = datos.trackName();
        this.artistName = datos.artistName();
        this.duration = datos.duration();
        this.albumName = datos.albumName();

    }

    @Override
    public String toString() {
        return "📘 Cancion: " + trackName + "\n✍️ Artista: " + artistName + "\n🌐 Album: " + albumName + "\n⬇️ Duracion: " + duration + " minutos." +"\n🔗 Id: " + id + "\n";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
