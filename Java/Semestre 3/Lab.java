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
            System.out.println("(M) Ingrese un numero entre 1 y 1000");
            M = leer.nextInt();
        }
        while (1 > M || M > 100);
        
        do{
            System.out.println("(N) Ingrese un numero entre 1 y 1000");
            N = leer.nextInt();
        }
        while (1 > N || N > 1000);
        
        System.out.println(M);
        System.out.println(N);
        
        int[][] matriz = new int [M][N]; // declaracion de la matriz
        
        for(int i = 0; i < M; i++)
        {
            for(int j = 0; j < N; j++)
            {
                System.out.print("Ingrese un elemento");
                matriz[i][j] = leer.nextInt();
            }
        }
        
	}
}