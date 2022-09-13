package com.spartaglobal.ymao.sorter;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import static com.spartaglobal.ymao.util.RandomArray.*;

public class MergeSortTest extends SortTest {

    @Override
    @Test
    public void testLarge() {
        initialiseLarge();
        assertArrayEquals(getResult(), new MergeSort().sort(getInput()));
    }

    @Override
    @Test
    public void testZero() {
        initialiseZero();
        assertArrayEquals(getResult(), new MergeSort().sort(getInput()));
    }

    @Override
    @Test
    public void testSorted() {
        initialiseLarge();
        assertArrayEquals(getResult(), new MergeSort().sort(getResult()));
    }

}
