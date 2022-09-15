package com.spartaglobal.ymao.model.sorters;

import com.spartaglobal.ymao.model.Sort;

public class Heapsort extends Sort {

    private static final Heapsort HEAPSORT = new Heapsort();

    private Heapsort() {}

    public static Heapsort getInstance() {
        return HEAPSORT;
    }

    @Override
    protected void sortHelper(int[] array, int length) {
        for (int index = length / 2 - 1; index >= 0; index--) {
            heapify(array, length, index);
        }
        for (int index = length - 1; index > 0; index--) {
            int temp = array[0];
            array[0] = array[index];
            array[index] = temp;
            heapify(array, index, 0);
        }
    }

    private static void heapify(int[] array, int length, int index) {
        int max = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < length && array[left] > array[max]) {
            max = left;
        }
        if (right < length && array[right] > array[max]) {
            max = right;
        }
        if (max != index) {
            int temp = array[index];
            array[index] = array[max];
            array[max] = temp;
            heapify(array, length, max);
        }
    }

}
