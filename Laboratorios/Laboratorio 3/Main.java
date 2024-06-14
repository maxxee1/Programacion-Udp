package stotify2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear la base de datos de canciones
        BaseDeDatosCanciones baseDeDatos = new BaseDeDatosCanciones();

        // Proporciona la ruta completa al archivo CSV;
        cargarCancionesDesdeCSV(baseDeDatos,"C:\\Code\\songs.csv");
        // Obtener la lista de canciones
        List<Cancion> canciones = baseDeDatos.getCanciones();

        // Verificar si la lista de canciones está vacía
        if (canciones.isEmpty()) {
            System.out.println("La lista de canciones está vacía. Asegúrate de que el archivo CSV esté correctamente formateado y no esté vacío.");
            return;
        }

        // Arreglos para los métodos de ordenamiento
        List<Cancion> desordenadas = new ArrayList<>(canciones);
        List<Cancion> mergeSorted = new ArrayList<>(canciones);
        List<Cancion> quickSorted = new ArrayList<>(canciones);
        List<Cancion> insertionSorted = new ArrayList<>(canciones);
        List<Cancion> bubbleSorted = new ArrayList<>(canciones);

        // Medir y realizar los ordenamientos
        long start, finish;

        //MergeSort
        start = System.nanoTime();
        mergeSorted = MetodosOrdenamiento.mergeSort(mergeSorted);
        finish = System.nanoTime();
        System.out.println("MergeSort time: " + (finish - start) + " ns.");

        // QuickSort
        start = System.nanoTime();
        quickSorted = MetodosOrdenamiento.quickSort(quickSorted);
        finish = System.nanoTime();
        System.out.println("QuickSort time: " + (finish - start) + " ns.");

        // InsertionSort
        start = System.nanoTime();
        insertionSorted = MetodosOrdenamiento.insertionSort(insertionSorted);
        finish = System.nanoTime();
        System.out.println("InsertionSort time: " + (finish - start) + " ns.");

        // BubbleSort
        start = System.nanoTime();
        bubbleSorted = MetodosOrdenamiento.bubbleSort(bubbleSorted);
        finish = System.nanoTime();
        System.out.println("BubbleSort time: " + (finish - start) + " ns.");

        // Construir los árboles
        ArbolBinario arbolBalanceadoPorNombre = ArbolBinario.crearArbolBalanceadoPorNombre(mergeSorted);
        ArbolBinario arbolDesordenadoPorNombre = new ArbolBinario();
        arbolDesordenadoPorNombre.crearArbol(desordenadas);

        List<Cancion> sortedPorDuracion = MetodosOrdenamiento.mergeSortPorDuracion(desordenadas);
        ArbolBinario arbolPorDuracion = ArbolBinario.crearArbolBalanceadoPorDuracion(sortedPorDuracion);

        // Realizar consultas y medir tiempos
        int Q = 100; // número de consultas

        long tiempoTotalOrdenado = 0;
        long tiempoTotalDesordenado = 0;
        long tiempoTotalDuracion = 0;

        for (int i = 0; i < Q && i < canciones.size(); i++) {
            String nombre = canciones.get(i).nombre;
            int duracion = canciones.get(i).duracion;

            // Búsqueda en árbol desordenado por nombre
            start = System.nanoTime();
            arbolDesordenadoPorNombre.buscarCancionPorNombre(nombre);
            finish = System.nanoTime();
            tiempoTotalDesordenado += (finish - start);

            // Búsqueda en árbol balanceado por nombre
            start = System.nanoTime();
            arbolBalanceadoPorNombre.buscarCancionPorNombre(nombre);
            finish = System.nanoTime();
            tiempoTotalOrdenado += (finish - start);

            // Búsqueda en árbol por duración
            start = System.nanoTime();
            arbolPorDuracion.buscarCancionPorDuracion(duracion);
            finish = System.nanoTime();
            tiempoTotalDuracion += (finish - start);
        }

        
        System.out.println("Tiempo total consultas en árbol desordenado por nombre: " + tiempoTotalDesordenado + " ns.");
        System.out.println("Tiempo total consultas en árbol balanceado por nombre: " + tiempoTotalOrdenado + " ns.");
        System.out.println("Tiempo total consultas en árbol por duración: " + tiempoTotalDuracion + " ns.");
    }
    private static void cargarCancionesDesdeCSV(BaseDeDatosCanciones baseDeDatos, String rutaArchivo) {
        String linea;
        int id = 0; // Inicializar ID como 0 o cualquier otra lógica de generación de ID
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length < 3) {
                    // Evitar procesar líneas que no tienen el formato adecuado.
                    System.err.println("Línea ignorada debido a formato inválido: " + linea);
                    continue;
                }
        
                String nombre = datos[1];
                try {
                    int duracion = Integer.parseInt(datos[2]);
                    baseDeDatos.agregarCancion(new Cancion(id++, nombre, duracion)); // Incrementar id
                } catch (NumberFormatException e) {
                    // Manejo de error si el segundo campo no es un número válido.
                    System.err.println("Error al intentar convertir duración a número en la línea: " + linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    
