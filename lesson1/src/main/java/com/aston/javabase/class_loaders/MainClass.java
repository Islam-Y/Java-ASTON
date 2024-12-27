package com.aston.javabase.class_loaders;

import com.aston.javabase.Homework;

public class MainClass {

    public static void main(String[] args) {
//        Class<ClassLoaders> aClass = ClassLoaders.class;
//        printClassLoaders();
//        String string = "I love Java";
//        System.out.println(Homework.turnString(string));

//        int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
//        Homework.getDistinctNumbers(ints);

//        int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
//        System.out.println(Homework.findSecondMaxElement(arr));

//        String s = "    fly me    to the moon    ";
//        System.out.println(Homework.lengthOfLastWord(s));

        String str1 = "abc";
        String str2 = "112233";
        String str3 = "aba";
        String str4 = "112211";
        System.out.println(Homework.isPalindrome(str4));
    }

    private static void printClassLoaders() {

        ClassLoaders classLoaders = new ClassLoaders();

        classLoaders.printBootstrapClassLoaders();

        classLoaders.printPlatformClassLoaders();

        classLoaders.printApplicationClassLoaders();

        classLoaders.printReflectionExample();
    }
}
