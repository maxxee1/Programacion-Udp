import java.util.*;

class array {

    public static void main(String [] args) {

        System.out.println("Ingrese cuantas marcas de autos posee:");
        Scanner leer = new Scanner(System.in);
        int n = leer.nextInt();
        leer.nextLine(); // Consumir la nueva línea pendiente

        String[] autos = new String[n];

        for(int i = 0; i < n; i++) {
            System.out.println("Ingrese la marca " + (i + 1));
            String marca = leer.nextLine();
            autos[i] = marca;
        }
        leer.close();

    }
}