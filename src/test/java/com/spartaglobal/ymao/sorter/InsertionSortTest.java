package com.spartaglobal.ymao.sorter;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class InsertionSortTest extends SortTest {

    @Override
    @Test
    public void testLarge() {
        initialiseLarge();
        assertArrayEquals(getResult(), new InsertionSort().sort(getInput()));
    }

    @Override
    @Test
    public void testZero() {
        initialiseZero();
        assertArrayEquals(getResult(), new InsertionSort().sort(getInput()));
    }

    @Override
    @Test
    public void testSorted() {
        initialiseLarge();
        assertArrayEquals(getResult(), new InsertionSort().sort(getResult()));
    }

}
