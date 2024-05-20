/*import java.util.Collections;
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

    //METODOS  ESTRUCTURAS DINAMICAS (colas y listas)

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
    // Reproducir Playlist en orden (listas)
    public void reproducirPlaylistlista(LinkedList<Cancion> playlist) {
        listaCanciones = playlist; // Establecer la lista de canciones de la playlist
        reproducirCanciones(); // Llamar al método para reproducir las canciones
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
    // recibe las posiciones de las canciones a intercambiar (i,j)
    public void cambiarOrdenCanciones(int i, int j) {
        // Convertir la cola a una lista
        List<Cancion> listaCanciones = new LinkedList<>(colaCanciones);
        // Intercambiar las canciones
        Collections.swap(listaCanciones, i, j);
        // Convertir la lista a una cola
        colaCanciones = new LinkedList<>(listaCanciones);
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

     // Reproducir Playlist aleaotrio (listas)
     public void reproducirPlaylistlistaAleatorio(LinkedList<Cancion> Playlist) {
        List<Cancion> listaAleatoria = new LinkedList<>(Playlist);
        Collections.shuffle(listaAleatoria);
        listaCanciones = new LinkedList<>(listaAleatoria);
        reproducirCanciones();
    }

    // Cambiar orden de 2 canciones en la Playlist (listas)
    // recibe las posiciones de las canciones a intercambiar (i,j)
    public void cambiarOrdenCancionesLista(int i, int j) {
        // Intercambiar las canciones
        Collections.swap(listaCanciones, i, j);
    }


    //METODOS ESTRUCTURAS ESTATICAS (arreglos)----------

    // Agregar cancion
    public static Cancion[] agregarCancion(Cancion cancion, Cancion[] canciones) {
        for (int i = 0; i < canciones.length; i++) {
            if (canciones[i] == null) {
                canciones[i] = cancion;
                return canciones;
            }
        }
    
        // Si llegamos a este punto significa que el arreglo está lleno
        // Y creamos un nuevo arreglo con un tamaño mayor
        Cancion[] cancionesNuevas = new Cancion[canciones.length + 1];
    
        // Copiamos los elementos del arreglo original al nuevo.
        for (int i = 0; i < canciones.length; i++) {
            cancionesNuevas[i] = canciones[i];
        }
    
        // Agregamos la nueva canción al final del nuevo arreglo.
        cancionesNuevas[cancionesNuevas.length - 1] = cancion;
    
        // Devolvemos el nuevo arreglo.
        return cancionesNuevas;
    }

    // Quitar cancion (arreglos)
    public static Cancion[] quitarCancion(Cancion cancion, Cancion[] canciones) {
        // Creamos un nuevo arreglo para almacenar las canciones sin la canción a eliminar
        Cancion[] nuevoArreglo = new Cancion[canciones.length - 1];
        
        // Índice para el nuevo arreglo
        int j = 0;
        
        // Recorremos el arreglo original
        for (int i = 0; i < canciones.length; i++) {
            // Si la canción actual no es la que queremos eliminar se la agregamos al nuevo arreglo
            if (canciones[i] != cancion) {
                nuevoArreglo[j] = canciones[i];
                j++;
                
            }
        }
        
        // Devolvemos el nuevo arreglo que no contiene la canción
        return nuevoArreglo;
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
        // Llamar al método para reproducir la lista de canciones en orden aleatorio
        reproducirPlaylistlistaAleatorio(new LinkedList<>(listaCanciones));
    }

    // Cambiar posición de 2 canciones en la Playlist (arreglos)
    public static Cancion[] cambiarOrdenCancionesArreglo(int i, int j, Cancion[] canciones) {
        // Intercambiar las canciones
        Cancion temp = canciones[i];
        canciones[i] = canciones[j];
        canciones[j] = temp;
        return canciones;
    }
}*/