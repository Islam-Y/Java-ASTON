package com.aston.javabase;

import com.aston.javabase.Homework.MyArrayList;
import com.aston.javabase.Homework.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//import static com.aston.javabase.Homework.QuickSort.quickSort;

public class Main {
    public static void main(String[] args) {

        MyArrayList<String> arrayListC = new MyArrayList<>(5);
        MyArrayList<String> arrayList = new MyArrayList<>();
        arrayList.add("3");
        arrayList.add("6");
        arrayList.add("4");
        arrayList.add("7");
        arrayList.add("5");
        arrayList.add("1");

        arrayList.add(4, "92");

        arrayList.get(4);
        arrayList.remove(2);
        arrayList.remove("92");


        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        System.out.println("---------------------------");

        arrayList.sort(Comparator.naturalOrder());

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();

        arrayList.clear();
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        System.out.println("Hello world!");

        ArrayList <String> arrayListD = new ArrayList <>();
        arrayListD.add("1");
        arrayListD.add("1");
        arrayListD.add("1");
        arrayListD.add("1");
        arrayListD.add("1");
        for (String s : arrayListD) {
            System.out.println(s);
        }
        System.out.println("---------------------------");
        arrayListD.clear();
        for (String s : arrayListD) {
            System.out.println(s);
        }





//        int[] array = {17, 14, 15, 28, 6, 8, -6, 1, 3, 18};
//        System.out.println("Unsorted Array: " + Arrays.toString(array));
//        quickSort(array, 0, array.length - 1);
//        System.out.println("  Sorted Array: " + Arrays.toString(array));


        // Для сортировки чисел
        QuickSort<Integer> integerQuickSort = new QuickSort<>();
        List<Integer> numbers = new ArrayList<>(Arrays.asList(17, 14, 15, 28, 6, 8, -6, 1, 3, 18));
        integerQuickSort.quickSort(numbers);
        System.out.println("Sorted (Natural Order): " + numbers);

        // Для сортировки строк
        QuickSort<String> stringQuickSort = new QuickSort<>();
        List<String> strings = new ArrayList<>(Arrays.asList("apple", "orange", "banana", "grape", "kiwi"));
        stringQuickSort.quickSort(strings, Comparator.reverseOrder());
        System.out.println("Sorted (Reverse Order): " + strings);

    }
}