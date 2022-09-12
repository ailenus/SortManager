package com.spartaglobal.ymao.main;

import com.spartaglobal.ymao.sorter.*;

import static java.lang.System.nanoTime;

public class SortTime {
    public static long executionTime(Sort sort, int[] array) {
        long startTime;
        long endTime;
        if (sort.equals(Sort.BUBBLE_SORT)) {
            startTime = nanoTime();
            new BubbleSort().sort(array);
            endTime = nanoTime();
        } else if (sort.equals(Sort.INSERTION_SORT)) {
            startTime = nanoTime();
            new InsertionSort().sort(array);
            endTime = nanoTime();
        } else if (sort.equals(Sort.MERGE_SORT)) {
            startTime = nanoTime();
            new MergeSort().sort(array);
            endTime = nanoTime();
        } else if (sort.equals(Sort.QUICKSORT)) {
            startTime = nanoTime();
            new Quicksort().sort(array);
            endTime = nanoTime();
        } else if (sort.equals(Sort.SELECTION_SORT)) {
            startTime = nanoTime();
            new SelectionSort().sort(array);
            endTime = nanoTime();
        } else {// sort.equals(Sort.TREE_SORT)
            startTime = nanoTime();
            new TreeSort().sort(array);
            endTime = nanoTime();
        }
        return endTime - startTime;
    }
}
