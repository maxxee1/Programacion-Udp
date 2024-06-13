package AlgoritmosdeOrdenamiento;

public class Algoritmos {

    public static int [] generarArreglo() {
        int [] arreglo =new int [100];

        for (int i = 0; i < 100; i++) {
            int numero = (int) (Math.random() * 1000) + 1;
            arreglo[i] = numero;
        }
        return arreglo;
    }
    public static void imprimirArreglo(int [] arreglo) {

        int contador = 0;
        for (int i = 0; i < arreglo.length; i++) {

            System.out.print(arreglo[i] + " ");
            if(contador % 10 == 0) {System.out.println();}
            contador++;
        }
        System.out.println();
    }
    
    public static void bubbleSort (int [] arreglo) {

        int i, j;
        for (i = 0; i < arreglo.length - 1; i++) {
            // Últimos i elementos ya están en su lugar
            for (j = 0; j < arreglo.length - 1 - i; j++) {
                // Si el elemento actual es mayor que el siguiente, intercambiarlos
                if (arreglo[j] > arreglo[j + 1]) {
                    // Intercambio de elementos 
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort (int [] arreglo) {
            
        int i, j, minIndex;
        for (i = 0; i < arreglo.length - 1; i++) {
           // Encuentra el mínimo elemento en el arreglo
           minIndex = i;
            for (j = i + 1; j < arreglo.length; j++) {
                if (arreglo[j] < arreglo[minIndex]) {
                    minIndex = j;
                }
            }
            // Intercambio de elementos
            int temp = arreglo[minIndex];
            arreglo[minIndex] = arreglo[i];
            arreglo[i] = temp;
        }
    }

    public static void insertionSort (int [] arreglo) {

        int i, j, key;
        for (i = 1; i < arreglo.length; i++) {
            key = arreglo[i];
            j = i - 1;
            // Mover los elementos del arreglo[0..i-1], que son mayores que la clave, a una posición adelante de su posición actual
            while (j >= 0 && arreglo[j] > key) {
                arreglo[j + 1] = arreglo[j];
                j = j - 1;
            }
            arreglo[j + 1] = key;
        }
    }

    public static void merge (int [] arreglo, int l, int m, int r) {

        // Encuentra el tamaño de los dos subarreglos a ser fusionados
        int n1 = m - l + 1;
        int n2 = r - m;
        // Arreglos temporales
        int L[] = new int [n1];
        int R[] = new int [n2];
        // Copia los datos a los arreglos temporales
        for (int i = 0; i < n1; i++) {
            L[i] = arreglo[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arreglo[m + 1 + j];
        }
        // Fusiona los arreglos temporales
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arreglo[k] = L[i];
                i++;
            } else {
                arreglo[k] = R[j];
                j++;
            }
            k++;
        }
        // Copia los elementos restantes de L[], si hay alguno
        while (i < n1) {
            arreglo[k] = L[i];
            i++;
            k++;
        }
        // Copia los elementos restantes de R[], si hay alguno
        while (j < n2) {
            arreglo[k] = R[j];
            j++;
            k++;
        }
    }

    static int partition(int[] arreglo, int low, int high) {
        int pivot = arreglo[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arreglo[j] < pivot) {
                i++;
                int temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
            }
        }
        int temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[high];
        arreglo[high] = temp;
        return i + 1;
    }
    
    static void quickSort(int[] arreglo, int low, int high) {
        if (low < high) {
            int pi = partition(arreglo, low, high);
            quickSort(arreglo, low, pi - 1);
            quickSort(arreglo, pi + 1, high);
        }
    }

    public static void main(String[] args) {

        int [] arreglo = generarArreglo();
        imprimirArreglo(arreglo);
        bubbleSort(arreglo);
        imprimirArreglo(arreglo);
    }
}
