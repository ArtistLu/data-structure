public class ArrayQueue<E> implements Queue<E> {

    Array<E> arr = new Array<>();

    public ArrayQueue(int capacity) {
        arr = new Array<>(capacity);
    }

    public ArrayQueue() {
        arr = new Array<>();
    }

    @Override
    public int getSize() {
        return arr.getSize();
    }

    @Override
    public void enQueue(E e) {
        arr.addFirst(e);
    }

    @Override
    public E deQueue() {
        return arr.removeLast();
    }

    @Override
    public E getFront() {
        return arr.getLast();
    }

    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: [");
        for (int i = 0; i < arr.getSize(); i++) {
            res.append(arr.get(i));
            if (i != arr.getSize() - 1) {
                res.append(", ");
            }
        }

        res.append("] front");
        return res.toString();
    }
}
