package stotify2;

import java.util.List;
import java.util.ArrayList;

public class ArbolBinario {
    private class Nodo {
        Cancion cancion;
        Nodo izquierda, derecha;

        Nodo(Cancion cancion) {
            this.cancion = cancion;
            izquierda = derecha = null;
        }
    }

    private Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public void insertar(Cancion cancion) {
        raiz = insertarRec(raiz, cancion);
    }

    private Nodo insertarRec(Nodo raiz, Cancion cancion) {
        if (raiz == null) {
            raiz = new Nodo(cancion);
            return raiz;
        }
        if (cancion.nombre.compareTo(raiz.cancion.nombre) < 0)
            raiz.izquierda = insertarRec(raiz.izquierda, cancion);
        else if (cancion.nombre.compareTo(raiz.cancion.nombre) > 0)
            raiz.derecha = insertarRec(raiz.derecha, cancion);
        return raiz;
    }

    public int buscarCancionPorNombre(String nombre) {
        Nodo res = buscarRec(raiz, nombre);
        return res != null ? res.cancion.id : -1;
    }

    private Nodo buscarRec(Nodo raiz, String nombre) {
        if (raiz == null || raiz.cancion.nombre.equals(nombre))
            return raiz;
        if (raiz.cancion.nombre.compareTo(nombre) > 0)
            return buscarRec(raiz.izquierda, nombre);
        return buscarRec(raiz.derecha, nombre);
    }

    public List<Integer> buscarCancionPorDuracion(int duracion) {
        List<Integer> ids = new ArrayList<>();
        buscarRecPorDuracion(raiz, duracion, ids);
        return ids;
    }

    private void buscarRecPorDuracion(Nodo raiz, int duracion, List<Integer> ids) {
        if (raiz != null) {
            if (raiz.cancion.duracion == duracion) {
                ids.add(raiz.cancion.id);
            }
            buscarRecPorDuracion(raiz.izquierda, duracion, ids);
            buscarRecPorDuracion(raiz.derecha, duracion, ids);
        }
    }

    public void crearArbol(List<Cancion> canciones) {
        for (Cancion cancion : canciones) {
            insertar(cancion);
        }
    }

    public static ArbolBinario crearArbolBalanceadoPorNombre(List<Cancion> canciones) {
        List<Cancion> sortedCanciones = MetodosOrdenamiento.mergeSort(canciones);
        return crearArbolBalanceado(sortedCanciones, 0, sortedCanciones.size() - 1);
    }

    private static ArbolBinario crearArbolBalanceado(List<Cancion> canciones, int start, int end) {
        ArbolBinario arbol = new ArbolBinario();
        if (start <= end) {
            int mid = (start + end) / 2;
            arbol.insertar(canciones.get(mid));
            arbol.raiz.izquierda = crearArbolBalanceado(canciones, start, mid - 1).raiz;
            arbol.raiz.derecha = crearArbolBalanceado(canciones, mid + 1, end).raiz;
        }
        return arbol;
    }

    public static ArbolBinario crearArbolBalanceadoPorDuracion(List<Cancion> canciones) {
        List<Cancion> sortedCanciones = MetodosOrdenamiento.mergeSortPorDuracion(canciones);
        return crearArbolBalanceadoPorDuracion(sortedCanciones, 0, sortedCanciones.size() - 1);
    }

    private static ArbolBinario crearArbolBalanceadoPorDuracion(List<Cancion> canciones, int start, int end) {
        ArbolBinario arbol = new ArbolBinario();
        if (start <= end) {
            int mid = (start + end) / 2;
            arbol.insertar(canciones.get(mid));
            arbol.raiz.izquierda = crearArbolBalanceadoPorDuracion(canciones, start, mid - 1).raiz;
            arbol.raiz.derecha = crearArbolBalanceadoPorDuracion(canciones, mid + 1, end).raiz;
        }
        return arbol;
    }
}
