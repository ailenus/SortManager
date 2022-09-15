package com.spartaglobal.ymao.model.sorters;

import com.spartaglobal.ymao.model.Sort;

public class SelectionSort extends Sort {

    private static final SelectionSort SELECTION_SORT = new SelectionSort();

    private SelectionSort() {}

    public static SelectionSort getInstance() {
        return SELECTION_SORT;
    }

    @Override
    protected void sortHelper(int[] array, int length) {
        for (int index = 0; index < length - 1; index++) {
            int minIndex = index;
            for (int i = index + 1; i < length; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[index];
            array[index] = temp;
        }
    }

}
