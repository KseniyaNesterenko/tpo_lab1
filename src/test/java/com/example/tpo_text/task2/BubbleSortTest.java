package com.example.tpo_text.task2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BubbleSortTest {

    @Test
    @DisplayName("Тест пустого массива")
    void testEmptyArray() {
        int[] array = {};
        int[] expected = {};
        BubbleSort.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    @DisplayName("Тест массива из одного элемента")
    void testSingleElementArray() {
        int[] array = {42};
        int[] expected = {42};
        BubbleSort.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    @DisplayName("Тест уже отсортированного массива")
    void testAlreadySortedArray() {
        int[] array = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        BubbleSort.sort(array);
        assertArrayEquals(expected, array);
    }


    @Test
    @DisplayName("Тест массива с дубликатами")
    void testArrayWithDuplicates() {
        int[] array = {5, 3, 8, 3, 9, 1, 5};
        int[] expected = {1, 3, 3, 5, 5, 8, 9};
        BubbleSort.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    @DisplayName("Тест массива с отрицательными числами")
    void testArrayWithNegativeNumbers() {
        int[] array = {-3, -1, -7, -5, -9};
        int[] expected = {-9, -7, -5, -3, -1};
        BubbleSort.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    @DisplayName("Тест массива с отрицательными, положительными числами и 0")
    void testArrayWithMixedNegativePositiveAndZero() {
        int[] array = {0, -1, 3, -5, 2, -8, 6};
        int[] expected = {-8, -5, -1, 0, 2, 3, 6};
        BubbleSort.sort(array);
        assertArrayEquals(expected, array);
    }
}
