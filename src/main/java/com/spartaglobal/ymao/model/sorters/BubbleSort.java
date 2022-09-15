package com.spartaglobal.ymao.model.sorters;

import com.spartaglobal.ymao.model.Sort;

public class BubbleSort extends Sort {

    private static final BubbleSort BUBBLE_SORT = new BubbleSort();

    private BubbleSort() {}

    public static BubbleSort getInstance() {
        return BUBBLE_SORT;
    }

    @Override
    protected void sortHelper(int[] array, int length) {
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
