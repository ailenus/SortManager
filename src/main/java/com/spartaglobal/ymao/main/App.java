package com.spartaglobal.ymao.main;

import com.spartaglobal.ymao.util.Utility;

public class App {

    public static void main(String[] args) {

        int[] array = Utility.random(10_000, Integer.MAX_VALUE);

        for (Sort sort : Sort.values()) {
            System.out.println(sort.toString().toLowerCase() + ":\n    "
                    + SortTime.executionTime(sort, array) + " nanoseconds");
        }

    }

}
