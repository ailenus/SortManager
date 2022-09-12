package com.spartaglobal.ymao.sorter;

import org.junit.Test;

import static com.spartaglobal.ymao.util.Utility.*;

public abstract class SortTest {

    public final void initialiseLarge() {
        initialise(10_000, Integer.MAX_VALUE);
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
