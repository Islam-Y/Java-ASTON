package com.aston.javabase;

import com.aston.javabase.Homework.MyArrayList;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> numbers = new MyArrayList<>();
        numbers.add(1000);
        numbers.add(950);
        numbers.add(100);
        numbers.add(150);
        numbers.add(200);
        numbers.add(250);
        numbers.add(300);
        numbers.add(900);
        numbers.add(850);
        numbers.add(800);
        numbers.sort(Comparator.naturalOrder());

    }
}