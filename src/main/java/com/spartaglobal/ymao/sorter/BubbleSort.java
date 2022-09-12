package com.spartaglobal.ymao.sorter;

public class BubbleSort extends Sort {

    @Override
    protected void sortHelper(int[] array) {
        int length = array.length;
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
