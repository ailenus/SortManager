package com.spartaglobal.ymao.sorter;

import java.util.Arrays;

public abstract class Sort implements Sorter {

    @Override
    public final int[] sort(int[] input) {
        int[] result = Arrays.copyOf(input, input.length);
        sortHelper(result);
        return result;
    }

    protected abstract void sortHelper(int[] array);

}
