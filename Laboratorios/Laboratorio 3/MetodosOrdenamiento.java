package stotify2;

import java.util.ArrayList;
import java.util.List;

public class MetodosOrdenamiento {

    // MergeSort
    public static List<Cancion> mergeSort(List<Cancion> canciones) {
        if (canciones.size() <= 1) {
            return canciones;
        }

        int middle = canciones.size() / 2;
        List<Cancion> left = new ArrayList<>(canciones.subList(0, middle));
        List<Cancion> right = new ArrayList<>(canciones.subList(middle, canciones.size()));

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static List<Cancion> merge(List<Cancion> left, List<Cancion> right) {
        List<Cancion> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).nombre.compareTo(right.get(j).nombre) <= 0) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }

    // QuickSort
    public static List<Cancion> quickSort(List<Cancion> canciones) {
        List<Cancion> sorted = new ArrayList<>(canciones);
        quickSortRec(sorted, 0, sorted.size() - 1);
        return sorted;
    }

    private static void quickSortRec(List<Cancion> canciones, int low, int high) {
        if (low < high) {
            int pi = partition(canciones, low, high);
            quickSortRec(canciones, low, pi - 1);
            quickSortRec(canciones, pi + 1, high);
        }
    }

    private static int partition(List<Cancion> canciones, int low, int high) {
        Cancion pivot = canciones.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (canciones.get(j).nombre.compareTo(pivot.nombre) <= 0) {
                i++;
                Cancion temp = canciones.get(i);
                canciones.set(i, canciones.get(j));
                canciones.set(j, temp);
            }
        }

        Cancion temp = canciones.get(i + 1);
        canciones.set(i + 1, canciones.get(high));
        canciones.set(high, temp);

        return i + 1;
    }

    // InsertionSort1
    public static List<Cancion> insertionSort(List<Cancion> canciones) {
        List<Cancion> sorted = new ArrayList<>(canciones);
        for (int i = 1; i < sorted.size(); i++) {
            Cancion key = sorted.get(i);
            int j = i - 1;
            while (j >= 0 && sorted.get(j).nombre.compareTo(key.nombre) > 0) {
                sorted.set(j + 1, sorted.get(j));
                j = j - 1;
            }
            sorted.set(j + 1, key);
        }
        return sorted;
    }
    //insertionSort2
    /*public static List<Cancion> insertionSort(List<Cancion> canciones) {
        List<Cancion> sorted = new ArrayList<>(canciones);
        for (int i = 1; i < sorted.size(); i++) {
            Cancion key = sorted.get(i);
            int j = i - 1;
            System.out.println("i: " + i + ", key: " + key);
            while (j >= 0 && sorted.get(j).getDuracion() > key.getDuracion()) {
                sorted.set(j + 1, sorted.get(j));
                j = j - 1;
                System.out.println("j: " + j);
            }
            sorted.set(j + 1, key);
        }
        return sorted;
    }*/
    

    // BubbleSort
    public static List<Cancion> bubbleSort(List<Cancion> canciones) {
        List<Cancion> sorted = new ArrayList<>(canciones);
        int n = sorted.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sorted.get(j).nombre.compareTo(sorted.get(j + 1).nombre) > 0) {
                    Cancion temp = sorted.get(j);
                    sorted.set(j, sorted.get(j + 1));
                    sorted.set(j + 1, temp);
                }
            }
        }
        return sorted;
    }
    // MergeSort por duración
    public static List<Cancion> mergeSortPorDuracion(List<Cancion> canciones) {
        if (canciones.size() <= 1) {
            return canciones;
        }

        int middle = canciones.size() / 2;
        List<Cancion> left = new ArrayList<>(canciones.subList(0, middle));
        List<Cancion> right = new ArrayList<>(canciones.subList(middle, canciones.size()));

        left = mergeSortPorDuracion(left);
        right = mergeSortPorDuracion(right);

        return mergePorDuracion(left, right);
    }

    private static List<Cancion> mergePorDuracion(List<Cancion> left, List<Cancion> right) {
        List<Cancion> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).duracion <= right.get(j).duracion) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }
}
