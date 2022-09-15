package com.spartaglobal.ymao.sorters;

import com.spartaglobal.ymao.model.sorters.Quicksort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuicksortTest extends SortTest {

    @Override
    @Test
    public void testLarge() {
        initialiseLarge();
        assertArrayEquals(getResult(),
                Quicksort.getInstance().sort(getInput()));
    }

    @Override
    @Test
    public void testZero() {
        initialiseZero();
        assertArrayEquals(getResult(),
                Quicksort.getInstance().sort(getInput()));
    }

    @Override
    @Test
    public void testSorted() {
        initialiseLarge();
        assertArrayEquals(getResult(),
                Quicksort.getInstance().sort(getResult()));
    }

}
