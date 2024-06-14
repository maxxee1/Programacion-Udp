import java.util.PriorityQueue;

class DefaaultPriority {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        pq.add(50);
        pq.add(1);
        pq.add(8);

        System.out.println("PriorityQueue: " + pq);
    }
}