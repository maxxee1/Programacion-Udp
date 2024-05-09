package stotify.clases;

import java.util.ArrayList;

public class Playlist {
    private String playlistnombre;
    private ArrayList<Cancion> canciones;
    private Cancion[] arreglocanciones;

    // Constructor para usar lista enlazada
    public Playlist(String playlistnombre) {
        this.playlistnombre = playlistnombre;
        this.canciones = new ArrayList<Cancion>();
    }

    // Constructor para usar arreglo
    public Playlist(String nombre, int tamano) {
        this.playlistnombre = nombre;
        this.arreglocanciones = new Cancion[tamano];
    }

    // Getters
    public String getPlaylistnombre() {
        return playlistnombre;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    // Setters
    public void setPlaylistnombre(String playlistnombre) {
        this.playlistnombre = playlistnombre;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    // Metodo agregar cancion (arreglo de canciones)
    public void agregarCancionPlaylist(Cancion[] arreglocanciones, Cancion cancion) {
        for (int i = 0; i < arreglocanciones.length; i++) {
            if (arreglocanciones[i] == null) {
                arreglocanciones[i] = cancion;
                return;
            }
        }
        System.out.println("La playlist está llena, no se puede agregar más canciones.");
    }

    // Metodo agregar cancion (lista enlazada)
    public void agregarCancionPlaylist(Cancion cancion) {
        canciones.add(cancion);
    
    }
}


