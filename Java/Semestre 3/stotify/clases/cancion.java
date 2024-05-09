package stotify.clases;

public class Cancion {
    private String titulo;
    private String artista;
    private int duracion;
    
    
    public Cancion (String titulo, String artista, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }
    
    public String getArtista() {
        return artista;
    }

    public int getDuracion() {
        return duracion;
    }

    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}



