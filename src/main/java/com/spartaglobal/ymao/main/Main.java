package com.spartaglobal.ymao.main;

import java.io.IOException;
import java.util.Arrays;

import com.spartaglobal.ymao.sorter.Sorter;
import com.spartaglobal.ymao.util.InputProcessor;
import com.spartaglobal.ymao.util.RandomArray;
import com.spartaglobal.ymao.util.SortType;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("""
                Welcome to the sort manager application.
                Choose a sorting algorithm by entering its number option:
                0: bubble sort
                1: heapsort
                2: insertion sort
                3: merge sort
                4: quicksort
                5: selection sort
                6: tree sort""");
        int choice = InputProcessor.inputInteger("Enter your choice: ", 6);
        SortType sortType = SortType.values()[choice];
        System.out.println("""

                Choose the length of the array to be generated.
                The length should be between 0 and 5,000.""");
        int length = InputProcessor.inputInteger("Enter length: ", 5_000);
        int[] array = RandomArray.getRandomArray(length, 10_000);

        int[] sortedArray;
        long startTime;
        long endTime;
        Sorter sorter = SortType.getSorter(sortType);
        startTime = System.nanoTime();
        sortedArray = sorter.sort(array);
        endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        System.out.println("\nThe randomly generated array is as follows.");
        System.out.println(Arrays.toString(array));
        System.out.println("\nYour chosen sorting algorithm is "
            + sortType.toString().toLowerCase().replace("_", " ") + ".");
        System.out.println("\nThe sorted array is as follows.");
        System.out.println(Arrays.toString(sortedArray));
        System.out.println("\nThe execution time is " + executionTime
                + " nanoseconds.\n");

    }

}
