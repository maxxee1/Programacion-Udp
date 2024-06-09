package stotify2;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatosCanciones {
    private List<Cancion> canciones;

    public BaseDeDatosCanciones() {
        this.canciones = new ArrayList<>();
    }

    public void agregarCancion(Cancion cancion) {
        cancion.id = canciones.size() + 1;  // Asignar ID basado en el tamaño de la lista
        canciones.add(cancion);
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }
}
