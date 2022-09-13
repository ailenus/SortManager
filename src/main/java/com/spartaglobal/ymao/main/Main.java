package com.spartaglobal.ymao.main;

import java.io.IOException;
import java.util.Arrays;

import com.spartaglobal.ymao.sorter.Sorter;
import com.spartaglobal.ymao.util.InputProcessor;
import com.spartaglobal.ymao.util.RandomArray;
import com.spartaglobal.ymao.util.SortType;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to the sort manager application.\n"
                + "Choose a sorting algorithm by entering its number option:\n"
                + "0: bubble sort\n"
                + "1: heapsort\n"
                + "2: insertion sort\n"
                + "3: merge sort\n"
                + "4: quicksort\n"
                + "5: selection sort\n"
                + "6: tree sort");
        int choice = InputProcessor.inputInteger("Enter your choice: ",
                6);
        SortType sortType = SortType.values()[choice];
        System.out.println("Choose the length of the array to be generated.\n"
                + "The length should be between 0 and 5,000.");
        int length = InputProcessor.inputInteger("Enter length: ",
                5_000);
        int[] array = RandomArray.getRandomArray(length, 10_000);

        int[] sortedArray;
        long startTime;
        long endTime;
        Sorter sorter = SortType.getSorter(sortType);
        startTime = System.nanoTime();
        sortedArray = sorter.sort(array);
        endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        System.out.println("The randomly generated array is as follows.");
        System.out.println(Arrays.toString(array));
        System.out.println("Your chosen sorting algorithm is "
            + sortType.toString().toLowerCase().replace("_", " ") + ".");
        System.out.println("The sorted array is as follows.");
        System.out.println(Arrays.toString(sortedArray));
        System.out.println("The execution time is " + executionTime
                + " nanoseconds.");

    }

}
