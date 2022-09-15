package com.spartaglobal.ymao.controller.start;

import com.spartaglobal.ymao.model.Sorter;
import com.spartaglobal.ymao.model.SorterType;
import com.spartaglobal.ymao.model.sorters.*;

public class SorterFactory {

    public static Sorter getSorter(SorterType sorterType) {
        return switch (sorterType) {
            case BUBBLE_SORT -> BubbleSort.getInstance();
            case HEAPSORT -> Heapsort.getInstance();
            case INSERTION_SORT -> InsertionSort.getInstance();
            case MERGE_SORT -> MergeSort.getInstance();
            case QUICKSORT -> Quicksort.getInstance();
            case SELECTION_SORT -> SelectionSort.getInstance();
            case TREE_SORT -> TreeSort.getInstance();
        };
    }

}
