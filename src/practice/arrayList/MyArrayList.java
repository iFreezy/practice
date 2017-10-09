package practice.arrayList;


import java.util.Iterator;

public class MyArrayList<E> implements Iterable{
    // массив елементов
    private Object[] elements;

    // сколько элементов в данный момент
    private int size;

    // переменная, которая показывает в какой индекс добавлять новый елемент
    private int index;

    private static final int DEFAULT_CAPACITY = 16;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        elements = new Object[capacity];
    }

    public void add(E value) {
        if (index == elements.length)
            growArray();
        elements[index] = value;
        index++;
        size++;
    }

    // увеличить массив если в нем закончилось место
    private void growArray() {
        Object[] newArray = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, index );
        elements = newArray;
    }

    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.index)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
    }

    public void set(int index, int value) {
        checkIndex(index);
        elements[index] = value;
    }

    public int size() {
        return size;
    }

    // если элемента который равен value не будет, то вернуть -1
    public int indexOf(E value) {
        if (value == null){
            for (int i = 0; i < size; i++){
                if (elements[i] == null){
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++){
                if (value.equals(elements[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean add(int index, int value) {
        checkIndex(index);
        if (index == elements.length)
            growArray();

        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = value;
        this.index++;
        size++;

        return true;
    }

    public boolean remove(int index) {
        checkIndex(index);
        System.arraycopy(elements, index + 1, elements, index, this.index - index);
        size--;
        this.index--;

        return true;
    }

    public void addAll(MyArrayList<E>... arrays){
        int length = elements.length;

        for (MyArrayList<E> array : arrays) {
            length += array.size;
        }
        Object[] result = new Object[length];
        System.arraycopy(elements, 0, result, 0, index );
        int pos = index;
        for (MyArrayList<E> array : arrays) {
            for (Object element : array) {
                result[pos] = element;
                pos++;
            }
        }
        elements = result;
    }


    public boolean contains(Object o) {
        return indexOf((E) o) >= 0;
    }

    private void shiftToLeft(int pos) {
        size--;
        if (size <= 0) {
            return;
        }
        if (size != pos) {
            System.arraycopy(elements, pos + 1, elements, pos, size - pos);
        }
        elements[size] = null;
    }

    public boolean removeAll(MyArrayList<E> myList) {
        if (myList == null) {
            return false;
        }
        if ((myList.size() == 0) || (size == 0)) {
            return false;
        }
        boolean modyfied = false;
        int i = 0;
        while (i < size) {
            if (myList.contains(elements[i])) {
                shiftToLeft(i);
                modyfied = true;
            } else {
                i++;
            }
        }
        return modyfied;
    }

    public E findFirst(){
        checkIndex(0);
        return (E) elements[0];
    }
    public E findLast(){
        checkIndex(size()-1);
        return (E) elements[size()-1];
    }

    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {

            private int currentIndex = 0;
            private int currentSize = elements.length;

            @Override
            public boolean hasNext() {
                return currentIndex < currentSize && elements[currentIndex] != null;
            }

            @Override
            public E next() {
                return (E) elements[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }



}
