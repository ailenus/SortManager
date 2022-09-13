package com.spartaglobal.ymao.sorter;

import org.junit.Test;

import static com.spartaglobal.ymao.util.RandomArray.initialise;

public abstract class SortTest {

    public final void initialiseLarge() {
        initialise(5_000, Integer.MAX_VALUE);
    }
    
    public final void initialiseZero() {
        initialise(0, 1);
    }

    @Test
    public abstract void testLarge();

    @Test
    public abstract void testZero();

    @Test
    public abstract void testSorted();

}
