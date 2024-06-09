package GeneradorCVS;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SongCSVGenerator {
    // Lista de canciones reales (debería ser más extensa y precisa en un caso real)
    private static final String[] SONGS = {
        "Song A,210", "Song B,180", "Song C,240", "Song D,200",
        "Song E,260", "Song F,230", "Song G,250", "Song H,220",
        "Song I,190", "Song J,270"
    };

    private static final int NUM_SONGS = 1000000;
    private static final String OUTPUT_FILE = "million_songs_real.csv";

    public static void main(String[] args) {
        List<String> songList = new ArrayList<>();
        
        // Llenar la lista con 1,000,000 de canciones
        for (int i = 0; i < NUM_SONGS; i++) {
            songList.add(SONGS[i % SONGS.length]);
        }

        // Mezclar aleatoriamente la lista
        Collections.shuffle(songList, new Random());

        try (FileWriter writer = new FileWriter(OUTPUT_FILE)) {
            // Escribir encabezado
            writer.append("Name,Duration\n");

            // Escribir canciones
            for (String song : songList) {
                writer.append(song).append("\n");
            }
            System.out.println("Archivo CSV creado: " + OUTPUT_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
