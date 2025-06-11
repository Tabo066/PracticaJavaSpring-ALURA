package com.aluracursos.musica.repository;

import com.aluracursos.musica.model.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CancionRepository extends JpaRepository<Cancion, Integer> {
    Optional<Cancion> findByTrackNameAndArtistName(String trackName, String artistName);
}