package com.spartaglobal.ymao.sorters;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.spartaglobal.ymao.controller.SortManager.getRandomArray;

public abstract class SortTest {

    private static final int LARGE_LENGTH = 5_000;
    private static final int LARGE_BOUND = Integer.MAX_VALUE;
    private static final int ZERO_LENGTH = 0;
    private static final int ZERO_BOUND = 1;

    private static int[] input;
    private static int[] result;

    private static void initialise(int length, int bound) {
        input = getRandomArray(length, bound);
        result = Arrays.copyOf(input, length);
        Arrays.sort(result);
    }

    protected static void initialiseLarge() {
        initialise(LARGE_LENGTH, LARGE_BOUND);
    }
    
    protected static void initialiseZero() {
        initialise(ZERO_LENGTH, ZERO_BOUND);
    }

    protected static int[] getInput() {
        return input;
    }

    protected static int[] getResult() {
        return result;
    }

    @Test
    public abstract void testLarge();

    @Test
    public abstract void testZero();

    @Test
    public abstract void testSorted();

}
