import java.util.PriorityQueue;

class DefaaultPriority {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        PriorityQueue<Integer> lambdapq = new PriorityQueue<Integer>((a, b) -> b - a);

        // agregando items a la cola de prioridad
        pq.add(50);
        pq.add(1);
        pq.add(8);

        // agregando items a la cola de prioridad con lambda
        lambdapq.add(10);
        lambdapq.add(20);
        lambdapq.add(30);


        // ---------- Cola de prioridad por defecto ----------

       System.err.println("Cola de prioridad por defecto");
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.peek());
        System.out.println(pq.poll());

        // ---------- Cola de prioridad con lambda ----------

        System.err.println("Cola de prioridad con lambda");
        System.out.println(lambdapq.peek());
        System.out.println(lambdapq.poll());
        System.out.println(lambdapq.peek());
        System.out.println(lambdapq.poll());
        System.out.println(lambdapq.peek());
        System.out.println(lambdapq.poll());
    }
}