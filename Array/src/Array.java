public class Array<E> {

    private int size;
    private E[] data;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引超范围");
        }

        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }


    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引超范围");
        }

        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引超范围");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        boolean contain = false;
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)) {
                contain = true;
            }
        }

        return contain;
    }

    public int find(E e) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)) {
                index = i;
            }
        }

        return index;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index is illegal");
        }

        E ret = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;

        //当减少到四分之一xxxx
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (-1 != index) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }

        }

        res.append(" ]");

        return res.toString();

    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }
}
