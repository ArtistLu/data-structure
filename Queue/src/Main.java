import java.util.Random;

public class Main {

    private static double testQueue(Queue<Integer> q, int opCount) {

        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {

            int ran = random.nextInt(Integer.MAX_VALUE);
            q.enQueue(ran);
            System.out.println("enqueue: " + ran);
        }

        for (int i = 0; i < opCount; i++) {
            System.out.println("dequeue: " + q.deQueue());
        }
        long end = System.nanoTime();

        return (end - start) / 1000000000;
    }

    public static void main(String[] args) {
//	    ArrayQueue<Integer> queue = new ArrayQueue<>();
//
//	    for (int i = 0; i < 10; i++) {
//	        queue.enQueue(i);
//        }
//
//        System.out.println(queue);
//
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println(String.format("size: %d", queue.getSize()));
//            System.out.println(String.format("front: %d", queue.getFront()));
//            System.out.println(String.format("dequeue: %d", queue.deQueue()));
//            System.out.println(queue);
//
//        }

        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();

        double arrayCost = testQueue(arrayQueue, opCount);
        System.out.println("arrayQueue cost: " + arrayCost + "s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();

        double loopCost = testQueue(loopQueue, opCount);
        System.out.println("loopQueue cost: " + loopCost + "s");

    }
}
