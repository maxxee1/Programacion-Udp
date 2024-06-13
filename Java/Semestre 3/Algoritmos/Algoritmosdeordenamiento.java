package Algoritmos;

public class Algoritmosdeordenamiento {

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

    public static void main(String[] args) {

        int [] arreglo = generarArreglo();
        imprimirArreglo(arreglo);
        bubbleSort(arreglo);
        imprimirArreglo(arreglo);
    }
}
