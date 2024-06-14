import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    public void insertar(int valor) {
        heap.add(valor);
        heapificarDesdeAbajo(heap.size() - 1);
    }

    public Integer extraerMaximo() {
        if (heap.isEmpty()) {
            return null;
        }
        if (heap.size() == 1) {
            return heap.remove(0);
        }
        int valorMaximo = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        heapificarDesdeArriba(0);
        return valorMaximo;
    }

    public Integer eliminar(int indice) {
        if (heap.isEmpty() || indice >= heap.size()) {
            return null;
        }
        if (heap.size() == 1) {
            return heap.remove(0);
        }
        int eliminado = heap.get(indice);
        heap.set(indice, heap.remove(heap.size() - 1));
        if (indice > 0 && heap.get(indice) > heap.get((indice - 1) / 2)) {
            heapificarDesdeAbajo(indice);
        } else {
            heapificarDesdeArriba(indice);
        }
        return eliminado;
    }

    private void heapificarDesdeAbajo(int indice) {
        int indicePadre = (indice - 1) / 2;
        if (indicePadre >= 0 && heap.get(indice) > heap.get(indicePadre)) {
            intercambiar(indice, indicePadre);
            heapificarDesdeAbajo(indicePadre);
        }
    }

    private void heapificarDesdeArriba(int indice) {
        int indiceHijoIzquierdo = 2 * indice + 1;
        int indiceHijoDerecho = 2 * indice + 2;
        int indiceMayor = indice;

        if (indiceHijoIzquierdo < heap.size() && heap.get(indiceHijoIzquierdo) > heap.get(indiceMayor)) {
            indiceMayor = indiceHijoIzquierdo;
        }

        if (indiceHijoDerecho < heap.size() && heap.get(indiceHijoDerecho) > heap.get(indiceMayor)) {
            indiceMayor = indiceHijoDerecho;
        }

        if (indiceMayor != indice) {
            intercambiar(indice, indiceMayor);
            heapificarDesdeArriba(indiceMayor);
        }
    }

    private void intercambiar(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Método principal para probar el Heap
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insertar(10);
        heap.insertar(20);
        heap.insertar(5);
        heap.insertar(7);
        heap.insertar(30);

        System.out.println("Heap después de inserciones: " + heap.heap);

        Integer valorMaximo = heap.extraerMaximo();
        System.out.println("Valor máximo extraído: " + valorMaximo);
        System.out.println("Heap después de extraer el máximo: " + heap.heap);

        Integer valorEliminado = heap.eliminar(1);
        System.out.println("Valor eliminado: " + valorEliminado);
        System.out.println("Heap después de eliminación: " + heap.heap);
    }
}
