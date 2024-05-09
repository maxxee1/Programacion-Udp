package stotify.clases;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Reproductor {
    private Queue<Cancion> colaCanciones;
    private LinkedList<Cancion> listaCanciones;

    // constructor cola
    public Reproductor(Queue<Cancion> colaCanciones) {
        this.colaCanciones = colaCanciones;
    }

    // constructor lista
    public Reproductor(LinkedList<Cancion> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }

    // Getters
    public Queue<Cancion> getColaCanciones() {
        return colaCanciones;
    }

    public LinkedList<Cancion> getListaCanciones() {
        return listaCanciones;
    }

    // Setters
    public void setColaCanciones(Queue<Cancion> colaCanciones) {
        this.colaCanciones = colaCanciones;
    }

    public void setListaCanciones(LinkedList<Cancion> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }

    // METODOS LISTAS

    // Agregar canción a la cola de reproducción (listas)
    public void agregarCancion(Cancion cancion) {
        listaCanciones.add(cancion);
    }

    // Quitar canción de la cola de reproducción (listas)
    public void quitarCancion(Cancion cancion) {
        listaCanciones.remove(cancion);
    }

    // Reproducir canciones en orden usando listas enlazadas
    public void reproducirCanciones() {
        // Recorrer la lista de canciones y reproducirlas
        for (Cancion cancion : listaCanciones) {
            // Simular la reproducción de la canción
            System.out.println("Reproduciendo: " + cancion.getTitulo());
        }
    }

    // Reproducir Playlist
    public void reproducirPlaylistlista(LinkedList<Cancion> playlist) {
        listaCanciones = playlist; // Establecer la lista de canciones de la playlist
        reproducirCanciones(); // Llamar al método para reproducir las canciones
    }


    // METODOS COLAS

    // Agregar cancion (colas)
    public void agregarCancioncola(Cancion cancion) {
        colaCanciones.offer(cancion);
    }

    // Quitar cancion (cola)
    public void quitarCancioncola(Cancion cancion) {
        colaCanciones.poll();
    }

    // Reproducir canciones en orden de la cola
    public void reproducirCancion(Queue<Cancion> cola) {
        if (!cola.isEmpty()) {
            while (!cola.isEmpty()) {
                System.out.println("Reproduciendo: " + cola.poll().getTitulo());
            }
        } 
        else {
            System.out.println("La cola de canciones está vacía.");
        }
    }

    // Reproducir Playlist en orden (cola)
    public void reproducirPlaylistcola(Queue<Cancion> Playlist) {
        reproducirCancion(Playlist);
    }

    // Reproducir Playlist en orden aleatorio
     public static void reproducirPlaylistAleatoria(List<Cancion> listaCanciones) {
        // Mezclar la lista de canciones
        Collections.shuffle(listaCanciones);
        
        // Reproducir las canciones de la lista mezclada
        for (Cancion cancion : listaCanciones) {
            System.out.println("Reproduciendo: " + cancion.getTitulo());
        }
    }
}
    
