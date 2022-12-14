package com.spartaglobal.ymao.sorters;

import com.spartaglobal.ymao.model.sorters.BubbleSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BubbleSortTest extends SortTest {

    @Override
    @Test
    public void testLarge() {
        initialiseLarge();
        assertArrayEquals(getResult(),
                BubbleSort.getInstance().sort(getInput()));
    }

    @Override
    @Test
    public void testZero() {
        initialiseZero();
        assertArrayEquals(getResult(),
                BubbleSort.getInstance().sort(getInput()));
    }

    @Override
    @Test
    public void testSorted() {
        initialiseLarge();
        assertArrayEquals(getResult(),
                BubbleSort.getInstance().sort(getResult()));
    }

}
