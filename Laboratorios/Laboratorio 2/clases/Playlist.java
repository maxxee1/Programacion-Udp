package stotify.clases;

import java.util.LinkedList;


public class Playlist {
    private String playlistnombre;
    private LinkedList<Cancion> canciones;
    private Cancion[] arreglocanciones;
    private int tamano;
    private int capacidad;

    // Constructor para usar lista enlazada
    public Playlist(String playlistnombre) {
        this.playlistnombre = playlistnombre;
        this.canciones = new LinkedList<>();
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

    public LinkedList<Cancion> getCanciones() {
        return canciones;
    }

    // Setters
    public void setPlaylistnombre(String playlistnombre) {
        this.playlistnombre = playlistnombre;
    }

    public void setCanciones(LinkedList<Cancion> canciones) {
        this.canciones = canciones;
    }
   
    /*----------METODOS ESTATICOS (arreglos)----------*/

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

    // Quitar cancion
    public void quitarCancion(Cancion cancion) {

        // Creamos un nuevo array para almacenar las canciones sin la canción a eliminar
        Cancion[] nuevoArreglo = new Cancion[arreglocanciones.length - 1];
        
        // Índice para el nuevo arreglo
        int j = 0;
        
        // Recorremos el arreglo original
        for (int i = 0; i < arreglocanciones.length; i++) {
            // Si la canción actual no es la que queremos eliminar se la agregamos al nuevo arreglo
            if (arreglocanciones[i] != cancion) {
                nuevoArreglo[j] = arreglocanciones[i];
                j++;
                
            }
        }
        
        // Reemplazamos el arreglo original con el nuevo arreglo que no contiene la canción
        arreglocanciones = nuevoArreglo;
    }

    /*----------METODOS DINAMICOS (lista enlazada, colas)----------*/

    // Metodo agregar cancion (lista enlazada)
    public void agregarCancionPlaylist(Cancion cancion) {
        canciones.add(cancion);
    }

    // Metodo eliminar cancion (lista enlazada)
    public void eliminarCancionPlaylist(Cancion cancion) {
        canciones.remove(cancion);
    }

    // Metodo eliminar TODAS las canciones iguales (lista enlazada)
    public void eliminarTodascancion(Cancion cancion) {

        for(int i=0; i< canciones.size(); i++) {
            if(canciones.get(i).equals(cancion)) {
                canciones.remove(i);
            }
        }
    }
}