package stotify2;
import java.util.*;
import java.io.*;

public class TestGenerator {
    public static void main(String[] args) {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();

        // Constants
        int songQty = 100; // 10 millon
        int queryQty = songQty / 10; // 10% of songQty
        int songNameLenght = 20;

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        List<Character> input = new ArrayList<>();
        for(char c : alphabet) input.add(c);

        ArrayList<String> songs = new ArrayList<>();
        for(int i = 0; i < songQty; i++){
            // Name
            Collections.shuffle(input);
            for (Character c : input) sb.append(c);
            String songName = sb.toString().substring(0, songNameLenght); // Length = 20 chars

            // Duration in seconds (between 100 and 10000)
            int duration = 100 + rnd.nextInt(10000);

            // Output: id,name,duration
            songs.add(i + "," + songName + "," + String.valueOf(duration));

            // Reset StringBuilder to re-use
            sb.delete(0, sb.length());
        }

        // Queries Per Name
        ArrayList<String> aux = new ArrayList<>(songs);
        Collections.shuffle(aux);
        ArrayList<String> queriesPerName = new ArrayList<>(aux.subList(0, queryQty));

        // Queries Per Duration
        ArrayList<String> queriesPerDuration = new ArrayList<>();
        for(int i = 0; i < queryQty; i++) {
            int duration = 100 + rnd.nextInt(10000);
            queriesPerDuration.add(String.valueOf(duration));
        }

        // Dump to CSV from ArrayList
        arrayListToCSV(songs, "songs");
        arrayListToCSV(queriesPerName, "queriesPerName");
        arrayListToCSV(queriesPerDuration, "queriesPerDuration");
    }

    public static void arrayListToCSV(ArrayList<String> list, String fileName) {
        try (FileWriter writer = new FileWriter(fileName + ".csv")) {
            for (String line : list) {
                writer.write(line + "\n");
            }
            System.out.println("CSV file " + fileName + " created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
