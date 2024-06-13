package Arboles;
import java.util.*;

/*---------- Clase para representar un nodo en el BST ----------*/
class NodoBST {
    int valor;
    NodoBST izquierda, derecha;

    // Constructor
    public NodoBST(int item) {
        valor = item;
        izquierda = derecha = null;
    }
}


/*---------- Clase para el árbol binario de búsqueda ----------*/
class BST {
    // Raíz del árbol
    NodoBST raiz;
    // Constructor
    public BST() {
        raiz = null;
    }


    // Método para insertar un valor en el árbol
    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }


    // Método recursivo para insertar un valor en el árbol
    private NodoBST insertarRec(NodoBST raiz, int valor) {
        // Si el árbol está vacío, crea un nuevo nodo
        if (raiz == null) {
            raiz = new NodoBST(valor);
            return raiz;
        }

        // Recorre el árbol
        if (valor < raiz.valor) {
            raiz.izquierda = insertarRec(raiz.izquierda, valor);
        } else if (valor > raiz.valor) {
            raiz.derecha = insertarRec(raiz.derecha, valor);
        }

        // Retorna el puntero al nodo raíz
        return raiz;
    }


    /*---------- Metodos para recorrer el arbol*/
    void inorder(NodoBST raiz) {
        if (raiz != null) {
            inorder(raiz.izquierda);
            System.out.print(raiz.valor + " ");
            inorder(raiz.derecha);
        }
    }
    void preorder(NodoBST raiz) {
        if (raiz != null) {
            System.out.print(raiz.valor + " ");
            preorder(raiz.izquierda);
            preorder(raiz.derecha);
        }
    }
    void postorder(NodoBST raiz) {
        if (raiz != null) {
            postorder(raiz.izquierda);
            postorder(raiz.derecha);
            System.out.print(raiz.valor + " ");
        }
    }
    void byleveltransversal(NodoBST raiz) {
        if (raiz == null) {
            return;  
        }
        Queue<NodoBST> q = new LinkedList<NodoBST>();
        q.add(raiz);
        while (!q.isEmpty()) {
            NodoBST temp = q.poll();
            System.out.print(temp.valor + " ");
            if (temp.izquierda != null) {
                q.add(temp.izquierda);
            }
            if (temp.derecha != null) {
                q.add(temp.derecha);
            }
        }
    
    }
}



/*---------- Metodo para llenar el arbol con numeros al azar----------*/
class LlenarArbol {
    public static void llenarArbol(BST arbol, int cantidad) {

        for (int i = 0; i < cantidad; i++) {
            int valor = (int) (Math.random() * 100);
            arbol.insertar(valor);
        }
    }
}


public class BinarySearchTree {
    public static void main(String[] args) {
        BST arbol = new BST();

        //Insertar elementos en el árbol
        //LlenarArbol.llenarArbol(arbol, 100);

        /*En este caso se insertan los elementos manualmente,
        para vizualizar mejor los recorridos: inorder, preorder, postorder*/
    
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(70);
        arbol.insertar(60);
        arbol.insertar(80);


        /*---------- Recorridos ----------*/

        System.out.println("Recorrido Inorder: ");
        arbol.inorder(arbol.raiz);
        System.out.println();
        System.out.println("Recorrido Preorder: ");
        arbol.preorder(arbol.raiz);
        System.out.println();
        System.out.println("Recorrido Postorder: ");
        arbol.postorder(arbol.raiz);
        System.out.println();
        System.out.println("Recorrido por nivel: ");
        arbol.byleveltransversal(arbol.raiz);

    }
}

