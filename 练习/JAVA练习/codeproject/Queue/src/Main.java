public class Main {
    public static void main(String[] args) {
        QueueAcess queue = new QueueAcess();
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println(queue.peek());
    }
}