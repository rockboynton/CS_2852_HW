package arraylist;

import java.util.List;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.RandomAccess;

public class ArrayList<E> implements List<E>, RandomAccess {
    private E[] elements = (E[])new Object[0];

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E element) {
        E[] newArray = (E[])new Object[size() + 1];
        for(int i = 0; i < size(); ++i) {
            newArray[i] = elements[i];
        }
        newArray[size()] = element;
        elements = newArray;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        boolean found = false;
        if (o != null) {
            for (int i = 0; i < elements.length && !found; i++) {
                if (o.equals(elements[i])) {
                    found = true;
                    E[] newArray = (E[]) new Object[size() - 1];
                    for (int j = 0; j < newArray.length; j++) {
                        newArray
                    }
                    elements = newArray;
                }
            }
        }
        return found;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        boolean found = false;
        if ()
        return found;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}

