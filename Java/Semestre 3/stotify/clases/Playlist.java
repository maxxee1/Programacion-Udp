package stotify.clases;

import java.util.ArrayList;

public class Playlist {
    private String playlistnombre;
    private ArrayList<Cancion> canciones;

    public Playlist(String playlistnombre) {
        this.playlistnombre = playlistnombre;
        this.canciones = new ArrayList<Cancion>();
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

}
