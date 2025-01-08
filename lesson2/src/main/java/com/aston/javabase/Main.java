package com.aston.javabase;

import com.aston.javabase.class_structure.Homework.MyArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

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
//        arrayList.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        System.out.println("---------------------------");
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
    }
}