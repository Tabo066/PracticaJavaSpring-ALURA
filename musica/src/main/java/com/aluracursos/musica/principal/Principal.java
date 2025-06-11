package com.aluracursos.musica.principal;
import com.aluracursos.musica.model.*;
import com.aluracursos.musica.repository.CancionRepository;
import com.aluracursos.musica.service.ConsumoAPI;
import com.aluracursos.musica.service.ConvierteDatos;
import java.util.*;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://lrclib.net/api/get?artist_name=";
    private final String URL_SONG = "&track_name=";
    private ConvierteDatos conversor = new ConvierteDatos();
    private CancionRepository cancionRepo;

    public Principal(CancionRepository cancionRepo) {
        this.cancionRepo = cancionRepo;
    }


    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar cancion por nombre de artista
                    2 - Mostrar canciones guardadas
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarCancionWeb();
                    break;
                case 2:
                    mostrarCancionesGuardadas();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

    private void buscarCancionWeb() {
        System.out.println("Escribe el nombre del artista a buscar:");
        String nombreArtista = teclado.nextLine();
        System.out.println("Escribe el nombre de la cancion:");
        String cancion = teclado.nextLine();

        String url = URL_BASE + nombreArtista.replace(" ", "+") + URL_SONG + cancion.replace(" ", "+");
        String json = consumoApi.obtenerDatos(url);
        DatosCancion datosCancion = conversor.obtenerDatos(json, DatosCancion.class);

        if (datosCancion == null) {
            System.out.println("No se encontraron resultados para: " + nombreArtista + " - " + cancion);
            return;
        }
        Optional<Cancion> existingSong = cancionRepo.findByTrackNameAndArtistName(datosCancion.trackName(), datosCancion.artistName());

        if (existingSong.isPresent()) {
            System.out.println("La canción ya está guardada en la base de datos.");
            return;
        }
        Cancion cancionToSave = new Cancion(datosCancion);
        cancionRepo.save(cancionToSave);
        System.out.println("✔️ Canción guardada:\n " + cancionToSave);
    }

        private void mostrarCancionesGuardadas() {
        List<Cancion> canciones = cancionRepo.findAll();
        if (canciones.isEmpty()) {
            System.out.println("📭 No hay canciones almacenadas aún.");
        } else {
            canciones.forEach(System.out::println);
        }
    }
}



