package com.spartaglobal.ymao.sorter;

public class InsertionSort extends Sort {

    @Override
    protected void sortHelper(int[] array) {
        int length = array.length;
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
