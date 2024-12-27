package com.aston.javabase;

import java.util.TreeSet;

public class Homework {

    // Перевернуть строку и вывести на консоль
//      String string = "I love Java";
    public static String turnString(String string) {
        char[] charArray = string.toCharArray();
        int right = charArray.length - 1;
        int left = 0;
        for (int i = 0; i < charArray.length / 2; i++) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }

        return new String(charArray);
    }

    // int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
    // Удалить дубликаты из массива и вывести в консоль
    public static void getDistinctNumbers(int[] ints) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < ints.length; i++) {
            set.add(ints[i]);
        }
        System.out.println(set);
    }

    // Дан массив, заполненный уникальными значениями типа int.
    // int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
    // Необходимо найти элемент, который меньше максимума, но больше всех остальных.
    public static Integer findSecondMaxElement(int[] arr) {
        int max = 0;
        int secondMax = max;

        for (int num : arr) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax) {
                secondMax = num;
            }

        }
        return secondMax;
    }

    // Найти длину последнего слова в строке. В строке только буквы и пробелы.
    // "Hello world" - 5
    // "    fly me    to the moon    " - 4
    public static Integer lengthOfLastWord(String string) {
        if (string == null || string.trim().isEmpty()) {
            return 0; // Возвращаем 0, если строка пустая или содержит только пробелы
        }
        String[] words = string.trim().split("\\s+");
        return words[words.length - 1].length();
    }

    // Определить, что строка является палиндромом
    // Сложность по памяти O(1), не создавать новые String, StringBuilder
    // Примеры:
    // abc - false
    // 112233 - false
    // aba - true
    // 112211 - true
    public static boolean isPalindrome(String string) {
        for (int i = 0; i < string.length() / 2; i++) {
            if (string.charAt(i) != string.charAt(string.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
