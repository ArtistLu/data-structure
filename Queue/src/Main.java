public class Main {

    public static void main(String[] args) {
	    ArrayQueue<Integer> queue = new ArrayQueue<>();

	    for (int i = 0; i < 10; i++) {
	        queue.enQueue(i);
        }

        System.out.println(queue);


        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("size: %d", queue.getSize()));
            System.out.println(String.format("front: %d", queue.getFront()));
            System.out.println(String.format("dequeue: %d", queue.deQueue()));
            System.out.println(queue);

        }

    }
}
