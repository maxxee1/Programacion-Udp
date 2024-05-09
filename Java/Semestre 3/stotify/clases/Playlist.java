package stotify.clases;

import java.util.ArrayList;

public class Playlist {
    private String playlistnombre;
    private ArrayList<Cancion> canciones;
    private Cancion[] arreglocanciones;
    private int tamano;
    private int capacidad;

    // Constructor para usar lista enlazada
    public Playlist(String playlistnombre) {
        this.playlistnombre = playlistnombre;
        this.canciones = new ArrayList<Cancion>();
    }

    // Constructor para usar arreglo
    public Playlist(String nombre, int capacidad) {
        this.playlistnombre = nombre;
        this.capacidad = capacidad;
        this.arreglocanciones = new Cancion[capacidad];
        tamano = 0;
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
    // METODOS ARREGLOS

    // Metodo agregar cancion
    public void agregarCancion(Cancion cancion) {
        if (tamano == capacidad) {
            expandirArreglo();
        }
        arreglocanciones[tamano] = cancion;
        tamano++;
    }

    // Método para expandir el arreglo cuando sea necesario
    private void expandirArreglo() {
        int nuevaCapacidad = (capacidad + 1) * 2;
        Cancion[] nuevoArreglo = new Cancion[nuevaCapacidad];
        System.arraycopy(arreglocanciones, 0, nuevoArreglo, 0, tamano);
        arreglocanciones = nuevoArreglo;
        capacidad = nuevaCapacidad;
    }

    // METODOS LISTA ENLAZADA

    // Metodo agregar cancion
    public void agregarCancionPlaylist(Cancion cancion) {
        canciones.add(cancion);
    }

    // Metodo eliminar cancion
    public void eliminarCancionPlaylist(Cancion cancion) {
        canciones.remove(cancion);
    }
}


