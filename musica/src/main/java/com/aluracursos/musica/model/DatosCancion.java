package com.aluracursos.musica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosCancion(
        int id,
        String name,
        String trackName,
        String artistName,
        String albumName,
        int duration,
        boolean instrumental,
        String plainLyrics,
        String syncedLyrics
) {}