Se implementó la clase predeterminada en Java para Priority Queue, la cual almacena los datos con prioridad, donde el entero de menor valor tiene mayor prioridad. Los métodos utilizados fueron los siguientes:

* Nombredetucola.add(int x); → Agrega el int x, con su prioridad asociada
* Nombredetucloa.poll(); → Retorna y elimina el elemento de mayor prioridad
* Nombredetucola.peek(); → Mira el elemnto de mayor prioridad

>[!NOTE]
>Para invertir la prioridad utilizando una función lambda, se proporciona "(a, b) -> a - b" como parámetro para nuestra PriorityQueue.


Pero la implementacion de una priority queue se realiza con heap, son arboles binaros completos que cumple con:

* Min Heap → El valor de cada nodo es es menor o igual al valor de sus hijos
* Max Heap → El valor de cada nodo es mayor o igual al valor de sus hijos

En ambos casos el nodo raiz es el nodo de mayor prioridad.

>[!TIP]
> Un Heap se puede representar como un arreglo y las posiciones claves son:
>* El hijo izquierdo de un nodo en la posicion i se encuentra en la posicion 2i + 1
>* El hijo derecho de un nodo en posicion i se encuentra en la posicion 2i + 2
>* El padre de un nodo en la posicion i se encuentra en la posicion [(i-1)/2], truncado al numero entero.