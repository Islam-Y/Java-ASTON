package com.aston.javabase.Homework;

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


import java.util.List;
import java.util.Comparator;

public class QuickSort<T> {

    // Основной метод для сортировки
    public void quickSort(List<T> list, Comparator<? super T> comparator) {
        if (list == null || list.size() < 2) {
            return; // Список пустой или состоит из одного элемента
        }
        quickSort(list, 0, list.size() - 1, comparator);
    }

    // Перегруженный метод для использования естественного порядка
    public void quickSort(List<T> list) {
        quickSort(list, 0, list.size() - 1, null);
    }

    private void quickSort(List<T> list, int left, int right, Comparator<? super T> comparator) {
        if (left < right) {
            int pi = partition(list, left, right, comparator);

            quickSort(list, left, pi - 1, comparator);
            quickSort(list, pi + 1, right, comparator);
        }
    }

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

    private void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}

