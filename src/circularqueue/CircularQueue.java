package circularqueue;

public class CircularQueue<E> {

    private E[] data;
    private int size;
    private int head;

    public CircularQueue(int capacity) {
        this.data = (E[]) new Object[capacity];
        size = 0;
        head = 0;
    }

    public boolean offer(E element) {
        boolean changed = false;
        if (size < data.length) {
            data[(head + size) % data.length] = element;
            size++;
            changed = true;
        }
        return changed;
    }

    public E poll() {
        E value = data[head];
        size--;
        head = (head + 1) % data.length;
        return value;
    }

    public E peek() {
        return data[head];
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
