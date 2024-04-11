import java.util.Arrays;
import java.util.Scanner;

public class Lab
{
	public static void main(String[] args)
	{
        Scanner leer = new Scanner(System.in); // creacion objeto Scanner
        System.out.println("Ingrese 2 numeros enteros M N" +
            ", separados por un espacio");
            
        int M, N;
        
        // declaracion y verificaciones de M y N 
        do{
            System.out.println("(M)(N) entre 1 y 1000");
            
            M = leer.nextInt();
            N = leer.nextInt();
        }
        while ((1 > M || M > 1000) || (1 > N || N > 1000)) ;
        
        
        int[][] matriz = new int [N][M]; // declaracion de la matriz
        
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < M; j++)
            {
                int valor;
                do {
                    System.out.print("Ingrese un elemento ["+i+"]["+j+"]: ");
                    valor = leer.nextInt();

                }while(valor < 1 || valor > Math.pow(10, 8));

            matriz[i][j] = valor;
            }
        }
        leer.close();

        for(int i = 0; i < N; i++)
        {
            System.out.println(Arrays.toString(matriz[i]));
        }
	}
}