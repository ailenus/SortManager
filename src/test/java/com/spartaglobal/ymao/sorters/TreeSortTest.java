package com.spartaglobal.ymao.sorters;

import com.spartaglobal.ymao.model.sorters.TreeSort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TreeSortTest extends SortTest {

    @Override
    @Test
    public void testLarge() {
        initialiseLarge();
        assertArrayEquals(getResult(), TreeSort.getInstance().sort(getInput()));
    }

    @Override
    @Test
    public void testZero() {
        initialiseZero();
        assertArrayEquals(getResult(), TreeSort.getInstance().sort(getInput()));
    }

    @Override
    @Test
    public void testSorted() {
        initialiseLarge();
        assertArrayEquals(getResult(),
                TreeSort.getInstance().sort(getResult()));
    }

}
