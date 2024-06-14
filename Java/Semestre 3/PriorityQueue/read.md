Se implementó la clase predeterminada en Java para Priority Queue, la cual almacena los datos con prioridad, donde el entero de menor valor tiene mayor prioridad. Los métodos utilizados fueron los siguientes:

* Nombredetucola.add(int x); → Agrega el int x, con su prioridad asociada
* Nombredetucloa.poll(); → Retorna y elimina el elemento de mayor prioridad
* Nombredetucola.peek(); → Mira el elemnto de mayor prioridad

>[!NOTE]
>Para invertir la prioridad utilizando una función lambda, se proporciona "(a, b) -> a - b" como parámetro para nuestra PriorityQueue.