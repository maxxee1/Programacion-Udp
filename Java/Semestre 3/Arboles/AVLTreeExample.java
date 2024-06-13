package Arboles;


// Clase para representar un nodo en el AVL
class NodoAVL {
    int valor, altura;
    NodoAVL izquierda, derecha;

    // Constructor
    public NodoAVL(int item) {
        valor = item;
        altura = 1;
    }
}

// Clase para el Árbol AVL
class AVL {
    NodoAVL raiz;

    // Constructor
    public AVL() {
        raiz = null;
    }

    // Función para obtener la altura de un nodo
    private int altura(NodoAVL nodo) {
        if (nodo == null)
            return 0;
        return nodo.altura;
    }

    // Función para obtener el balance de un nodo
    private int balance(NodoAVL nodo) {
        if (nodo == null)
            return 0;
        return altura(nodo.izquierda) - altura(nodo.derecha);
    }

    // Función para rotar a la derecha alrededor del nodo 'y'
    private NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.izquierda;
        NodoAVL T2 = x.derecha;

        // Realizar rotación
        x.derecha = y;
        y.izquierda = T2;

        // Actualizar alturas
        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;
        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;

        // Devolver nueva raíz
        return x;
    }

    // Función para rotar a la izquierda alrededor del nodo 'x'
    private NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.derecha;
        NodoAVL T2 = y.izquierda;

        // Realizar rotación
        y.izquierda = x;
        x.derecha = T2;

        // Actualizar alturas
        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;
        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;

        // Devolver nueva raíz
        return y;
    }

    // Función para insertar un valor en el AVL
    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    // Función recursiva para insertar un valor en el AVL
    private NodoAVL insertarRec(NodoAVL nodo, int valor) {
        // Paso 1: Realizar la inserción normal de un BST
        if (nodo == null)
            return new NodoAVL(valor);

        if (valor < nodo.valor)
            nodo.izquierda = insertarRec(nodo.izquierda, valor);
        else if (valor > nodo.valor)
            nodo.derecha = insertarRec(nodo.derecha, valor);
        else // No se permiten valores duplicados en el AVL
            return nodo;

        // Paso 2: Actualizar la altura del nodo actual
        nodo.altura = 1 + Math.max(altura(nodo.izquierda), altura(nodo.derecha));

        // Paso 3: Obtener el balance del nodo para verificar si se desbalanceó
        int balance = balance(nodo);

        // Si el nodo se desbalanceó, entonces hay 4 casos

        // Caso Izquierda-Izquierda
        if (balance > 1 && valor < nodo.izquierda.valor)
            return rotacionDerecha(nodo);

        // Caso Derecha-Derecha
        if (balance < -1 && valor > nodo.derecha.valor)
            return rotacionIzquierda(nodo);

        // Caso Izquierda-Derecha
        if (balance > 1 && valor > nodo.izquierda.valor) {
            nodo.izquierda = rotacionIzquierda(nodo.izquierda);
            return rotacionDerecha(nodo);
        }

        // Caso Derecha-Izquierda
        if (balance < -1 && valor < nodo.derecha.valor) {
            nodo.derecha = rotacionDerecha(nodo.derecha);
            return rotacionIzquierda(nodo);
        }

        // Devolver el nodo sin cambios si no está desbalanceado
        return nodo;
    }

    // Función para realizar un recorrido inorder (para verificar el árbol)
    public void inorder() {
        inorderRec(raiz);
    }

    // Función recursiva para recorrido inorder
    private void inorderRec(NodoAVL nodo) {
        if (nodo != null) {
            inorderRec(nodo.izquierda);
            System.out.print(nodo.valor + " ");
            inorderRec(nodo.derecha);
        }
    }
}

// Clase main
public class AVLTreeExample {
    public static void main(String[] args) {
        AVL avl = new AVL();

        // Inserción de valores en el AVL
        avl.insertar(10);
        avl.insertar(20);
        avl.insertar(30);
        avl.insertar(40);
        avl.insertar(50);
        avl.insertar(25);

        // Recorrido inorder para mostrar el AVL
        System.out.println("Recorrido Inorder del AVL:");
        avl.inorder();
    }
}
