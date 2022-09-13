package com.spartaglobal.ymao.sorter;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class BubbleSortTest extends SortTest {

    @Override
    @Test
    public void testLarge() {
        initialiseLarge();
        assertArrayEquals(getResult(), new BubbleSort().sort(getInput()));
    }

    @Override
    @Test
    public void testZero() {
        initialiseZero();
        assertArrayEquals(getResult(), new BubbleSort().sort(getInput()));
    }

    @Override
    @Test
    public void testSorted() {
        initialiseLarge();
        assertArrayEquals(getResult(), new BubbleSort().sort(getResult()));
    }

}
