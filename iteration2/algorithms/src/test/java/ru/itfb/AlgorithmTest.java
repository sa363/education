package ru.itfb;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmTest {
    int[] array = IntStream.generate(() -> new Random().nextInt(1000000)).limit(1000000).toArray();
    int[] sortedArray = Arrays.stream(array).sorted().toArray();

    @Test
    void linearSearch() {
        int target = 23;
        assertTrue(Algorithm.linearSearch(array, target));
    }

    @Test
    void bubbleSort() {
        Algorithm.bubbleSort(array);
        assertArrayEquals(sortedArray ,array);
    }

    @Test
    void binarySearch() {
        int[] sortedArray = {1, 2 ,3 ,4 ,5};
        int target = 3;
        assertEquals(2 ,Algorithm.binarySearch(sortedArray,target));
    }
}