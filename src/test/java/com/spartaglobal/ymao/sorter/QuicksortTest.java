package com.spartaglobal.ymao.sorter;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import static com.spartaglobal.ymao.util.RandomArray.getInput;
import static com.spartaglobal.ymao.util.RandomArray.getResult;

public class QuicksortTest extends SortTest {

    @Override
    @Test
    public void testLarge() {
        initialiseLarge();
        assertArrayEquals(getResult(), new Quicksort().sort(getInput()));
    }

    @Override
    @Test
    public void testZero() {
        initialiseZero();
        assertArrayEquals(getResult(), new Quicksort().sort(getInput()));
    }

    @Override
    @Test
    public void testSorted() {
        initialiseLarge();
        assertArrayEquals(getResult(), new Quicksort().sort(getResult()));
    }

}
