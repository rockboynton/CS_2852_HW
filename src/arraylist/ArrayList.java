package arraylist;

import java.util.List;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

public class ArrayList<E> implements List<E>, RandomAccess {
    private E[] elements = (E[])new Object[0];

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
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void clear() {
        elements = (E[])new Object[0];
    }

    @Override
    public boolean contains(Object target) {
        return indexOf(target)>=0;
    }

    @Override
    public E get(int index) { // Gagan says don't need the throws here
        boundsCheck(index);
        return elements[index];
    }

    @Override
    public int indexOf(Object target) {
        int indexFound = -1;
        for(int i = 0; indexFound<0 && i<size(); ++i) {
            if((target!=null && target.equals(elements[i])) || target==elements[i]) {
                indexFound = i;
            }
        }
        return indexFound;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public E remove(int index) {
        boundsCheck(index);
        E[] newArray = (E[])new Object[size()-1];
        E removedElement = get(index);
        for(int i = 0; i<index; ++i) {
            newArray[i] = elements[i];
        }
        for(int i = index; i<size()-1; ++i) {
            newArray[i] = elements[i+1];
        }
        elements = newArray;
        return removedElement;
    }

    @Override
    public boolean remove(Object target) {
        int index = indexOf(target);
        if(index>=0) {
            remove(index);
        }
        return index>=0;
    }

    @Override
    public E set(int index, E element) {
        boundsCheck(index);
        E replacedValue = get(index);
        elements[index] = element;
        return replacedValue;
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size()];
        for(int i = 0; i<size(); ++i) {
            newArray[i] = elements[i];
        }
        return newArray;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E> {
        private int currentPosition = -1;
        private boolean removeAllowed = false;

        @Override
        public boolean hasNext() {
            return currentPosition+1<size();
        }

        @Override
        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            removeAllowed = true;
            return elements[++currentPosition];
        }

        @Override
        public void remove() {
            if(!removeAllowed) {
                throw new IllegalStateException("Must call .next() prior to .remove()");
            }
            removeAllowed = false;
            ArrayList.this.remove(currentPosition--);
        }
    }

    private void boundsCheck(int index) {
        if(index<0 || index>=size()) {
            throw new IndexOutOfBoundsException("Index: " + index + " Size: " + size());
        }
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
