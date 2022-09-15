package com.spartaglobal.ymao.controller.start;

import com.spartaglobal.ymao.controller.SortManager;
import com.spartaglobal.ymao.model.Sorter;
import com.spartaglobal.ymao.model.SorterType;
import com.spartaglobal.ymao.view.DisplayManager;

public class Start {

    private static final SorterType[] SORTER_TYPES = SorterType.values();
    private static final int SORTER_COUNT = SORTER_TYPES.length;
    private static final int ARRAY_BOUND = 5_000;

    private static int sorterChoice;
    private static int arrayLength;
    private static SorterType sorterType;
    private static int[] input;
    private static int[] result;
    private static long executionTime;

    public static void start() {
        input();
        process();
        output();
    }

    private static void input() {
        sorterChoice = DisplayManager.getSorterChoice(SORTER_COUNT - 1);
        DisplayManager.printLineBreak();
        arrayLength = DisplayManager.getArrayLength(ARRAY_BOUND);
    }

    private static void process() {
        sorterType = SORTER_TYPES[sorterChoice];
        input = SortManager.getRandomArray(arrayLength, ARRAY_BOUND);
        Sorter sorter = SorterFactory.getSorter(sorterType);
        long startTime;
        long endTime;
        startTime = System.nanoTime();
        result = sorter.sort(input);
        endTime = System.nanoTime();
        executionTime = endTime - startTime;
    }

    private static void output() {
        DisplayManager.printOutput(input,
                sorterType.toString().toLowerCase().replace("_", " "), result,
                executionTime);
    }

}
