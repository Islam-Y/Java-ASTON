package com.aston.javabase.class_structure.Homework;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList <T> {
    private int size;
    private T[] array;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        this.array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        if (capacity < 0){
            throw new IllegalArgumentException();
        }
        this.array = (T[]) new Object[capacity];
    }

    public boolean add(T element){
        if(size == array.length){
           grow();
        }
        array[size] = element;
        size++;
        return true;
    }

    public boolean add(int index, T element){
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        if(size == array.length){
            grow();
        }
        
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
        return true;
    }

    public int size(){
        return size;
    }

    public T get(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }

        return array[index];
    }

    public T remove(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        T value = array[index];
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        size--;
        return value;
    }

//    public void clear(){
//        for (int i = 0; i < size; i++) {
//            array[i] = null;
//        }
//    }

    public void clear() {
        final Object[] es = array;
        for (int to = size, i = size = 0; i < to; i++)
            es[i] = null;
    }

    public boolean remove(Object o){
        if(o == null){
            for (int i = 0; i < size; i++) {
                if (array[i] == null){
                    System.arraycopy(array, i + 1, array, i, array.length - i - 1);
                    size--;
                    return true;

                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i])){
                    System.arraycopy(array, i + 1, array, i, array.length - i - 1);
                    size--;
                    return true;
                }
            }
        }

        return false;
    }

    public void sort(Comparator<T> comparator){
        Arrays.sort(array, 0, size, comparator);
    }


    private void grow(){
        T[] newArray = (T[]) new Object[array.length + (array.length >> 1)];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
}
