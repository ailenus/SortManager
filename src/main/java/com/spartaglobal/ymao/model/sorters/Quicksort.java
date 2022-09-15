package com.spartaglobal.ymao.model.sorters;

import com.spartaglobal.ymao.model.Sort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Quicksort extends Sort {

    private static final Logger LOGGER = LogManager.getLogger(Quicksort.class);

    private static final Quicksort QUICKSORT = new Quicksort();

    private Quicksort() {}

    public static Quicksort getInstance() {
        return QUICKSORT;
    }

    @Override
    protected void sortHelper(int[] array, int length) {
        LOGGER.info("Inside Quicksort.sortHelper.");
        quicksort(array, 0, length - 1);
    }

    private static void quicksort(int[] array, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(array, start, end);
            quicksort(array, start, partitionIndex - 1);
            quicksort(array, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int index = start - 1;
        for (int i = start; i < end; i++) {
            if (array[i] <= pivot) {
                index++;
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
            }
        }
        index++;
        int temp = array[index];
        array[index] = array[end];
        array[end] = temp;
        return index;
    }

}
