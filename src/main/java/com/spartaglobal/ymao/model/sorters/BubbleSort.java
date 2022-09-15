package com.spartaglobal.ymao.model.sorters;

import com.spartaglobal.ymao.model.Sort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BubbleSort extends Sort {

    private static final Logger LOGGER = LogManager.getLogger(BubbleSort.class);

    private static final BubbleSort BUBBLE_SORT = new BubbleSort();

    private BubbleSort() {}

    public static BubbleSort getInstance() {
        return BUBBLE_SORT;
    }

    @Override
    protected void sortHelper(int[] array, int length) {
        LOGGER.info("Inside BubbleSort.sortHelper.");
        for (int index = 0; index < length - 1; index++) {
            for (int i = 0; i < length - index - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
    }

}
