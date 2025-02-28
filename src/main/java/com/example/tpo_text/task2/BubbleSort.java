package com.example.tpo_text.task2;

public class BubbleSort {
    public static int[] sort(int[] array) {
        int n = array.length;
        boolean bubble;
        for (int i = 0; i < n - 1; i++) {
            bubble = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    bubble = true;
                }
            }
            if (!bubble) break;
        }
        return array;
    }
}
