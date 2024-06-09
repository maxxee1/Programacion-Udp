//packageLaboratorios;

import java.util.Scanner;

public class invertir {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(" Ingresa un numero decimal : ");
        float numero = scanner.nextFloat();

        float numeroInvertido = invertirDecimal(numero);

        System.out.println(" Numero invertido : " + numeroInvertido);

        scanner.close();
    }

    public static float invertirDecimal(float numero) {
        int parteEntera = (int) numero;
        float parteDecimal = numero - parteEntera;

        int numeroInvertidoEntero = invertirEntero(parteEntera);
        float numeroInvertidoDecimal = invertirDecimalParteDecimal(parteDecimal);

        return numeroInvertidoEntero + numeroInvertidoDecimal;
    }

    public static int invertirEntero(int numero) {
        int numeroInvertido = 0;
        while (numero != 0) {
            numeroInvertido = numeroInvertido * 10 + numero % 10;
            numero /= 10;
        }
        return numeroInvertido;
    }

    public static float invertirDecimalParteDecimal(float numero) {
        float numeroInvertido = 0;
        float factor = 1;
        while (numero != 0) {
            factor /= 10;
            numeroInvertido += (numero % 10) * factor;
            numero *= 10;
            numero = (int) numero;
        }
        return numeroInvertido;
    }
}
