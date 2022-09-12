package com.spartaglobal.ymao.sorter;

public class SelectionSort extends Sort {

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
