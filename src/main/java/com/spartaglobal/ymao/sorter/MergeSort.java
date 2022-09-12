package com.spartaglobal.ymao.sorter;

public class MergeSort extends Sort {

    @Override
    protected void sortHelper(int[] array) {
        int length = array.length;
        mergeSort(array, length);
    }

    private static void mergeSort(int[] array, int length) {
        if (length < 2) {
            return;
        }
        int mid = length / 2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, length - mid);
        mergeSort(left, mid);
        mergeSort(right, length - mid);
        merge(array, left, right, mid, length - mid);
    }

    private static void merge(int[] array, int[] left, int[] right,
            int leftLength, int rightLength) {
        int index = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < leftLength && rightIndex < rightLength) {
            if (left[leftIndex] <= right[rightIndex]) {
                array[index] = left[leftIndex];
                index++;
                leftIndex++;
            } else {
                array[index] = right[rightIndex];
                index++;
                rightIndex++;
            }
        }
        while (leftIndex < leftLength) {
            array[index] = left[leftIndex];
            index++;
            leftIndex++;
        }
        while (rightIndex < rightLength) {
            array[index] = right[rightIndex];
            index++;
            rightIndex++;
        }
    }

}
