package com.spartaglobal.ymao.sorter;

import org.junit.Test;

import static com.spartaglobal.ymao.util.RandomArray.getRandomArray;

import java.util.Arrays;;

public abstract class SortTest {

    private static int[] input;
    private static int[] result;

    private static void initialise(int length, int bound) {
        input = getRandomArray(length, bound);
        result = Arrays.copyOf(input, length);
        Arrays.sort(result);
    }

    protected final static void initialiseLarge() {
        initialise(5_000, Integer.MAX_VALUE);
    }
    
    protected final static void initialiseZero() {
        initialise(0, 1);
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
