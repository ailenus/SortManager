package com.spartaglobal.ymao.model.sorters;

import com.spartaglobal.ymao.model.Sort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertionSort extends Sort {

    private static final Logger LOGGER = LogManager.getLogger(InsertionSort.class);

    private static final InsertionSort INSERTION_SORT = new InsertionSort();

    private InsertionSort() {}

    public static InsertionSort getInstance() {
        return INSERTION_SORT;
    }

    @Override
    protected void sortHelper(int[] array, int length) {
        LOGGER.info("Inside InsertionSort.sortHelper.");
        for (int index = 1; index < length; index++) {
            int key = array[index];
            int i = index - 1;
            while (i >= 0 && array[i] > key) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }

}
