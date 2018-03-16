package linkedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<E> implements List<E> {

    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this(value, null);
        }

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;

    @Override
    public boolean add(E element) {
        if(head==null) {
            head = new Node(element);
            tail = head;
        } else {
            tail.next = new Node(element);
            tail = tail.next;
        }
        return true;
    }

    @Override
    public void add(int index, E element) {
        if(index==0) {
            head = new Node<>(element, head);
        } else {
            Node<E> walker = walkTo(index - 1);
            walker.next = new Node<>(element, walker.next);
        }
        if(index==size()-1) {
            tail = walkTo(size()-1);
        }
    }

    private Node<E> walkTo(int index) {
        if(index<0 || index>size()) {
            throw new IndexOutOfBoundsException("Size: " + size() + " Index: " + index);
        }
        Node<E> walker = head;
        for (int i = 0; i < index; ++i) {
            walker = walker.next;
        }
        return walker;
    }


    @Override
    public void clear() {
        head = null;
        tail = null;
    }

    @Override
    public boolean contains(Object target) {
        return indexOf(target)>=0;
    }

    @Override
    public E get(int index) {
        return walkTo(index).value;
    }

    @Override
    public int indexOf(Object target) {
        int indexFound = -1;
        Node<E> elem = head;
        for(int i = 0; indexFound < 0 && i < size(); ++i) {
            if((target!=null && target.equals(elem.value)) || target == elem.value) {
                indexFound = i;
            } else {
                elem = elem.next;
            }
        }
        return indexFound;

    }

    @Override
    public boolean isEmpty() {
        return head==null;
    }

    @Override
    public E remove(int index) {
        E removed = get(index);
        if(!isEmpty() && index==0) {
            head = head.next;
            if(isEmpty()) {
                tail = null;
            }
        } else if(index==size()-1) {
            tail = walkTo(index-1);
            tail.next = null;
        } else {
            Node<E> walker = walkTo(index-1);
            walker.next = walker.next.next;
        }
        return removed;
    }

    @Override
    public boolean remove(Object target) {
        int index = indexOf(target);
        if(index >= 0) {
            remove(index);
        }
        return index >=0 ;

    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Implemented as part of class exercise");
    }

    @Override
    public int size() {                // Times run | Time to run statement
        int size = 0;                  // 1            c1
        Node<E> walker = head;         // 1            c2
        while(walker!=null) {          // n+1          c3
            size++;                    // n            c4
            walker = walker.next;      // n            c5
        }
        return size;                   // 1            c6
    }
    // T(n) = c1 + c2 + c3 + c6 + n * (c3 + c4 + c5)
    //      = a + n*b
    //      = O(n)

    @Override
    public Object[] toArray() {
        E[] elements = (E[]) new Object[size()];
        Node<E> walker = head;
        for (int i = 0; walker != null; i++) {
            elements[i] = walker.value;
            walker = walker.next;
        }
        return elements;
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /* Not planning to implement methods below */

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public int lastIndexOf(Object target) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

