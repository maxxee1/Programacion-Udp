import java.util.PriorityQueue;

class DefaaultPriority {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        PriorityQueue<Integer> lambdapq = new PriorityQueue<Integer>();

        // agregando items a la cola de prioridad
        pq.add(50);
        pq.add(1);
        pq.add(8);

        // agregando items a la cola de prioridad con lambda
        lambdapq.add(10);
        lambdapq.add(20);
        lambdapq.add(30);


        System.out.println("PriorityQueue: " + pq);
        System.out.println("PriorityQueue con lambda: " + lambdapq);
    }
}