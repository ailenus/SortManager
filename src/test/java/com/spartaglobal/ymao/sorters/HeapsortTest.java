package com.spartaglobal.ymao.sorters;

import com.spartaglobal.ymao.model.sorters.Heapsort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class HeapsortTest extends SortTest {

    @Override
    @Test
    public void testLarge() {
        initialiseLarge();
        assertArrayEquals(getResult(), Heapsort.getInstance().sort(getInput()));
    }

    @Override
    @Test
    public void testZero() {
        initialiseZero();
        assertArrayEquals(getResult(), Heapsort.getInstance().sort(getInput()));
    }

    @Override
    @Test
    public void testSorted() {
        initialiseLarge();
        assertArrayEquals(getResult(),
                Heapsort.getInstance().sort(getResult()));
    }

}
