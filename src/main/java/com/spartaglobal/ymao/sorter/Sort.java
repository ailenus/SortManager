package com.spartaglobal.ymao.sorter;

import java.util.Arrays;

public abstract class Sort implements Sorter {

    @Override
    public final int[] sort(int[] input) {
        int length = input.length;
        int[] result = Arrays.copyOf(input, length);
        sortHelper(result, length);
        return result;
    }

    protected abstract void sortHelper(int[] array, int length);

}
