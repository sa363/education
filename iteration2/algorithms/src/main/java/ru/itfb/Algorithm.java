package ru.itfb;

import java.util.logging.Logger;


public class Algorithm {

    Logger logger = Logger.getLogger(Algorithm.class.getName());

//    public static void main(String[] args) {
//
//    }


    // O(1) - сложность не зависит от размера входных данных
    public static boolean linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return true;
            }
        }
        return false;
    }
    // Сложность: O(n), где n - количество элементов в массиве

    public static void bubbleSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (array[j] > array[j+1]) {
                    // меняем элементы местами
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    // Сложность: O(n^2), где n - количество элементов в массиве



    public static int binarySearch(int[] sortedArray, int target) {
        int left = 0, right = sortedArray.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sortedArray[mid] == target)
                return mid;

            if (sortedArray[mid] < target)
                left = mid + 1;

            else
                right = mid - 1;
        }

        // Элемент не найден
        return -1;
    }// Сложность: O(log(n)), где n - количество элементов в отсортированном массиве



}