public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail, size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void enQueue(E e) {
        if (front == (tail + 1) % data.length) {
            resize(2 * getCapacity());
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E deQueue() {
        if (front == tail) {
            throw new IllegalArgumentException("queue is empty");
        }
        E res = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return res;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    public int getCapacity() {
        return data.length - 1;
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }

        data = newData;
        front = 0;
        tail = size;

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQuequ size = %d, capacity = %d front [", size, getCapacity()));
        for (int i = front; i % data.length != tail; i++) {
            res.append(data[i]);
            if (i != tail - 1) {
                res.append(", ");
            }
        }

        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
        }
        System.out.println(queue);
        queue.enQueue(0);


        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("size: %d", queue.getSize()));
            System.out.println(String.format("front: %d", queue.getFront()));
            System.out.println(String.format("dequeue: %d", queue.deQueue()));
            System.out.println(queue);

        }

    }
}
