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

    // Getters y Setters
    public Queue<Cancion> getColaCanciones() {
        return colaCanciones;
    }

    public void setColaCanciones(Queue<Cancion> colaCanciones) {
        this.colaCanciones = colaCanciones;
    }

    public LinkedList<Cancion> getListaCanciones() {
        return listaCanciones;
    }

    public void setListaCanciones(LinkedList<Cancion> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }

    /*---------- METODOS  ESTRUCTURAS DINAMICAS (colas y listas) ----------*/

    // Agregar canción (colas)
    public void agregarCancioncola(Cancion cancion) {
        colaCanciones.offer(cancion);
    }

    // Quitar canción (cola)
    public void quitarCancioncola(Cancion cancion) {
        colaCanciones.poll();
    }

    // Reproducir canciones en orden de la cola
    public void reproducirCancion(Queue<Cancion> cola) {
        if (!cola.isEmpty()) {
            while (!cola.isEmpty()) {
                System.out.println("Reproduciendo: " + cola.poll().getTitulo());
            }
        } else {
            System.out.println("La cola de canciones está vacía.");
        }
    }

    // Reproducir Playlist en orden (listas)
    public void reproducirPlaylistlista(LinkedList<Cancion> playlist) {
        listaCanciones = playlist;
        reproducirCanciones();
    }

    // Reproducir Playlist en orden (cola)
    public void reproducirPlaylistcola(Queue<Cancion> Playlist) {
        reproducirCancion(Playlist);
    }

    // Reproducir Playlist en orden aleatorio (cola)
    public void reproducirPlaylistcolaAleatorio(Queue<Cancion> Playlist) {
        List<Cancion> listaAleatoria = new LinkedList<>(Playlist);
        Collections.shuffle(listaAleatoria);
        Queue<Cancion> colaAleatoria = new LinkedList<>(listaAleatoria);
        reproducirCancion(colaAleatoria);
    }
    

    // Cambiar orden de 2 canciones en la Playlist (cola)
    public void cambiarOrdenCanciones(int i, int j) {
        List<Cancion> listaCanciones = new LinkedList<>(colaCanciones);
        Collections.swap(listaCanciones, i, j);
        colaCanciones = new LinkedList<>(listaCanciones);
    }

    // Quitar canción de la cola de reproducción (listas)
    public void quitarCancion(Cancion cancion) {
        listaCanciones.remove(cancion);
    }

    // Reproducir canciones en orden usando listas enlazadas
    public void reproducirCanciones() {
        for (Cancion cancion : listaCanciones) {
            System.out.println("Reproduciendo: " + cancion.getTitulo());
        }
    }


    // Cambiar orden de 2 canciones en la Playlist (listas)
    public void cambiarOrdenCancionesLista(int i, int j) {
        Collections.swap(listaCanciones, i, j);
    }

    /*----------METODOS ESTRUCTURAS ESTATICAS (arreglos)----------*/

    // Agregar canción
    public static Cancion[] agregarCancion(Cancion cancion, Cancion[] canciones) {
        for (int i = 0; i < canciones.length; i++) {
            if (canciones[i] == null) {
                canciones[i] = cancion;
                return canciones;
            }
        }

        Cancion[] cancionesNuevas = new Cancion[canciones.length + 1];

        for (int i = 0; i < canciones.length; i++) {
            cancionesNuevas[i] = canciones[i];
        }

        cancionesNuevas[cancionesNuevas.length - 1] = cancion;

        return cancionesNuevas;
    }

    // Quitar canción (arreglos)
    public static Cancion[] quitarCancion(Cancion cancion, Cancion[] canciones) {
        Cancion[] nuevoArreglo = new Cancion[canciones.length - 1];
        int j = 0;
        for (int i = 0; i < canciones.length; i++) {
            if (canciones[i] != cancion) {
                nuevoArreglo[j] = canciones[i];
                j++;
            }
        }
        return nuevoArreglo;
    }

    // Reproducir Playlist en orden aleatorio (listas)
    public void reproducirPlaylistlistaAleatorio(LinkedList<Cancion> playlist) {
        List<Cancion> listaAleatoria = new LinkedList<>(playlist);
        Collections.shuffle(listaAleatoria);
        reproducirCanciones(listaAleatoria);
    }

    // Reproducir canciones en orden usando listas enlazadas
    public void reproducirCanciones(List<Cancion> listaCanciones) {
        for (Cancion cancion : listaCanciones) {
            System.out.println("Reproduciendo: " + cancion.getTitulo());
        }
    }


    // Reproducir Playlist aleatorio (arreglos)
    public void reproducirPlaylistAleatorio(Cancion[] canciones) {
        // Convertir el arreglo a una lista
        List<Cancion> listaCanciones = new LinkedList<>();
        for (Cancion cancion : canciones) {
            if (cancion != null) {
                listaCanciones.add(cancion);
            }
        }
        // llamar al método para reproducir la lista de canciones en orden aleatorio
        reproducirPlaylistlistaAleatorio(new LinkedList<>(listaCanciones));
    }

    // Cambiar posición de 2 canciones en la Playlist (arreglos)
    public static Cancion[] cambiarOrdenCancionesArreglo(int i, int j, Cancion[] canciones) {
        Cancion temp = canciones[i];
        canciones[i] = canciones[j];
        canciones[j] = temp;
        return canciones;
    }
}
