//package Laboratorios;

import java.util.Arrays;
import java.util.Scanner;

public class Laboratorio1 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in); // creacion objeto Scanner
        System.out.println("Ingrese 2 numeros enteros M N" +
                ", separados por un espacio");

        int M, N;

        // declaracion y verificaciones de M y N
        do {
            System.out.println("(M)(N) entre 1 y 1000");

            M = leer.nextInt();
            N = leer.nextInt();
        } while ((1 > M || M > 1000) || (1 > N || N > 1000));

        int[][] matriz = new int[M][N]; // declaracion de la matriz

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int valor;
                do {
                    System.out.print("Ingrese un elemento [" + i + "][" + j + "]: ");
                    valor = leer.nextInt();

                } while (valor < 1 || valor > Math.pow(10, 8));

                matriz[i][j] = valor;
            }
        }

        for (int i = 0; i < M; i++) {
            System.out.println(Arrays.toString(matriz[i]));
        }

        int comp1, comp2;
        do {
            System.out.println("Ingrese 2 filas separadas por un espacio");
            comp1 = leer.nextInt() - 1;
            comp2 = leer.nextInt() - 1;
            if (comp1 > M || comp2 > M || comp1 < 0 || comp2 < 0) {
                System.out.println("Ingrese un valor mayor a 0 y menor a " + M + "!");
            }
        } while (comp1 > M || comp2 > M || comp1 < 0 || comp2 < 0);

        leer.close();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print("{" + matriz[comp1][i] + "," + matriz[comp2][j] + "}" + " ");

            }
        }
        System.out.println("");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print("{" + matriz[comp2][i] + "," + matriz[comp1][j] + "}" + " ");

            }
        }
    }
}