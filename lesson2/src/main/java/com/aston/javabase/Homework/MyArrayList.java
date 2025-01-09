package com.aston.javabase.Homework;

import java.util.*;


/**
 * The MyArrayList class shown below is a resizable array.
 * Allows the use of all elements, including null.
 *
 * The size, get, and operations are performed in constant time.
 * The add operation is performed in amortized constant time, that is, it takes O(n) time to add n elements.
 * All other operations are performed in linear time (roughly speaking).
 *
 * Each instance of MyArrayList has a specific capacity.
 * The capacity is the size of the array used to store the items in the list.
 * The size of the array is always at least the size of the list.
 * As items are added to the ArrayList, its capacity increases automatically.
 * Adding an element involves constant amortized time costs.
 * @param <T>
 */
public class MyArrayList <T>  {

    /**
     * The size of the ArrayList (the number of elements it contains).
     *
     * @serial
     */
    private int size;

    /**
     * The buffer of the array in which the MyArrayList elements are stored.
     * The capacity of MyArrayList is equal to the length of this array buffer.
     * An empty MyArrayList with element data is equal to a data array of size == DEFAULT_CAPACITY.
     */
    private T[] array;

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public MyArrayList() {
        this.array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param  capacity  the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity
     *         is negative
     */
    public MyArrayList(int capacity) {
        if (capacity < 0){
            throw new IllegalArgumentException();
        }
        this.array = (T[]) new Object[capacity];
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element element to be appended to this list
     * @return {@code true}
     */
    public boolean add(T element){
        if(size == array.length){
           grow();
        }
        array[size] = element;
        size++;
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
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

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size(){
        return size;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param  index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public T get(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }

        return array[index];
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public T remove(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        T value = array[index];
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        size--;
        array[size] = null;
        return value;
    }

    /**
     * Removes all of the elements from this list.  The list will
     * be empty after this call returns.
     */
    public void clear() {
        final Object[] es = array;
        for (int to = size, i = size = 0; i < to; i++)
            es[i] = null;
    }

    /**
     * Removes the first occurrence of the specified item from this list, if present.
     * If the list does not contain an element, it remains unchanged.
     * More formally, it overwrites the array by shifting all elements to the right of the first element equal to the element in the parameter,
     * so that the object is kind of overwritten.
     * o – element to be removed from this list, if present
     * Returns:
     * true if this list contained the specified element
     *
     * @param o element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     */
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

    /**
     * Sorts an array using quick sort and accepts a list of any type.
     * A comparator is used as a parameter, which provides different types of sorting.
     * @param comparator
     */
    public void sort(Comparator<T> comparator){
        array = Arrays.copyOf(array, size);
        QuickSort<T> quickSort = new QuickSort<>();
        List<T> list = new ArrayList<>(Arrays.asList(array));
        quickSort.quickSort(list, comparator);
        array = list.toArray(array);
    }

    /**
     * Trims the capacity of this {@code MyArrayList} instance to be the
     * list's current size.  An application can use this operation to minimize
     * the storage of an {@code MyArrayList} instance.
     */
    public void trimToSize() {
        if (size < array.length) {
            array = (size == 0)
                    ? (T[]) new Object[0]
                    : Arrays.copyOf(array, size);
        }
    }

    /**
     * Increases the capacity to ensure that the size of the array is increased by one and a half times.
     */
    private void grow(){
        T[] newArray = (T[]) new Object[array.length + (array.length >> 1)];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
}
