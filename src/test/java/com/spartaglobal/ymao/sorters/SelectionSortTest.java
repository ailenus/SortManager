package com.spartaglobal.ymao.sorters;

import com.spartaglobal.ymao.model.sorters.SelectionSort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SelectionSortTest extends SortTest {

    @Override
    @Test
    public void testLarge() {
        initialiseLarge();
        assertArrayEquals(getResult(),
                SelectionSort.getInstance().sort(getInput()));
    }

    @Override
    @Test
    public void testZero() {
        initialiseZero();
        assertArrayEquals(getResult(),
                SelectionSort.getInstance().sort(getInput()));
    }

    @Override
    @Test
    public void testSorted() {
        initialiseLarge();
        assertArrayEquals(getResult(),
                SelectionSort.getInstance().sort(getResult()));
    }

}
