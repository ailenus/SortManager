package com.spartaglobal.ymao.util;

import com.spartaglobal.ymao.sorter.*;

public enum SortType {

    BUBBLE_SORT, HEAPSORT, INSERTION_SORT, MERGE_SORT, QUICKSORT,
    SELECTION_SORT, TREE_SORT;

    public static Sorter getSorter(SortType sortType) {
        if (sortType == SortType.BUBBLE_SORT) {
            return new BubbleSort();
        } else if (sortType == SortType.HEAPSORT) {
            return new Heapsort();
        } else if (sortType == SortType.INSERTION_SORT) {
            return new InsertionSort();
        } else if (sortType == SortType.MERGE_SORT) {
            return new MergeSort();
        } else if (sortType == SortType.QUICKSORT) {
            return new Quicksort();
        } else if (sortType.equals(SortType.SELECTION_SORT)) {
            return new SelectionSort();
        } else {// sort.equals(Sort.TREE_SORT)
            return new TreeSort();
        }
    }

}
