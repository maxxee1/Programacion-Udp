package stotify2;

public class Cancion {
    int id; // Nueva propiedad para el ID
    int duracion; // en segundos
    String nombre;
    
    public Cancion(int id, String nombre, int duracion) {
        this.id = id; // Inicializar ID
        this.nombre = nombre;
        this.duracion = duracion; 
    }
    
    // Getter and Setter methods (optional, if needed)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
