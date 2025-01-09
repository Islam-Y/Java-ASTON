package com.aston.javabase.Homework;

import java.util.List;
import java.util.Comparator;

/**
 * The QuickSort<T> class performs a recursive quicksort using the Divide-and-Conquer methodology.
 * This class can accept any type of list and sort it.
 * For these purposes, the logic of Comparator and Comparable is implemented here.
 * @param <T>
 */
public class QuickSort<T> {

    /**
     * The main method for sorting through which the data will be received.
     * @param list
     * @param comparator
     */
    public void quickSort(List<T> list, Comparator<? super T> comparator) {
        if (list == null || list.size() < 2) {
            return;
        }
        quickSort(list, 0, list.size() - 1, comparator);
    }

    /**
     * An overloaded method for using natural order without Comparator
     * @param list
     */
    public void quickSort(List<T> list) {
        quickSort(list, 0, list.size() - 1, null);
    }

    /**
     * The basic logic of recursive quicksort.
     * Here, two variables are created that define the beginning and end of the array ( {@code left}, {@code right} ), as well as a {@code partition} that iterates and rearranges the elements.
     * @param list
     * @param left
     * @param right
     * @param comparator
     */
    private void quickSort(List<T> list, int left, int right, Comparator<? super T> comparator) {
        if (left < right) {
            int pi = partition(list, left, right, comparator);

            quickSort(list, left, pi - 1, comparator);
            quickSort(list, pi + 1, right, comparator);
        }
    }

    /**
     * The {@code partition} defines the pivot reference element. In this case, the element located in the middle was selected as the reference.
     * Based on it, the elements are arranged.
     * The variable {@code i} can be said to remember the positions where the element is larger than the pivot, and in the future,
     * when an element smaller than the pivot appears, the positions of the larger element with the smaller one are reversed.
     * It also defines the sorting order depending on the passed comparator.
     * After the calculations, the sum of the variable {@code i} and {@code 1} is returned as the next element after the last one that performed the permutation.
     * @param list
     * @param left
     * @param right
     * @param comparator
     * @return
     */
    private int partition(List<T> list, int left, int right, Comparator<? super T> comparator) {
        int middle = left + (right - left) / 2;
        T pivot = list.get(middle);

        // Переместим опорный элемент в конец
        swap(list, middle, right);

        int i = left - 1;

        for (int j = left; j < right; j++) {
            boolean comparison = comparator == null
                    ? ((Comparable<? super T>) list.get(j)).compareTo(pivot) < 0
                    : comparator.compare(list.get(j), pivot) < 0;

            if (comparison) {
                i++;
                swap(list, i, j);
            }
        }

        swap(list, i + 1, right);
        return i + 1;
    }

    /**
     * Swap performs a permutation of two elements of the array.
     * @param list
     * @param i
     * @param j
     */
    private void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}



/*
public class QuickSort {
    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pi = partition(array, left, right);

            quickSort(array, left, pi - 1);
            quickSort(array, pi + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int medium = left + ((right - left) / 2);
        int pivot = array[medium];

        int temp = array[medium];
        array[medium] = array[right];
        array[right] = temp;

        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (array[j] < pivot) {
                i++;

                swap(array, i, j);
            }

        }

        swap(array, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

 */