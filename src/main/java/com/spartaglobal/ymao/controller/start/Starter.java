package com.spartaglobal.ymao.controller.start;

import com.spartaglobal.ymao.controller.SortManager;
import com.spartaglobal.ymao.controller.exceptions.ModeException;
import com.spartaglobal.ymao.controller.exceptions.SortException;
import com.spartaglobal.ymao.model.Sorter;
import com.spartaglobal.ymao.model.SorterType;
import com.spartaglobal.ymao.view.DisplayManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Starter {

    private static final Logger LOGGER = LogManager.getLogger(Starter.class);

    private static final SorterType[] SORTER_TYPES = SorterType.values();
    private static final int MODE_BOUND = 1;
    private static final int SORTER_COUNT = SORTER_TYPES.length;
    private static final int LENGTH_BOUND = 5_000;
    private static final int ARRAY_BOUND = 10_000;

    private static int mode;
    private static int arrayLength;
    private static int[] input;
    private static int[] result;
    private static int sorter0;
    private static int sorter1;
    private static SorterType sorter0Type;
    private static SorterType sorter1Type;
    private static double executionTime0;
    private static double executionTime1;

    public static void start() {
        input();
        process();
        output();
    }

    private static void input() {
        mode = DisplayManager.getMode(MODE_BOUND);
        DisplayManager.printLineBreak();
        sorter0 = DisplayManager.getSorter(SORTER_COUNT - 1);
        if (mode == 1) {
            sorter1 = DisplayManager.getAnotherSorter(SORTER_COUNT - 1);
            while (sorter0 == sorter1) {
                DisplayManager.sameSorter();
                sorter1 = DisplayManager.getAnotherSorter(SORTER_COUNT - 1);
            }
        } else if (mode != 0) {
            try {
                throw new ModeException("Mode cannot be " + mode);
            } catch (Exception exception) {
                LOGGER.fatal(exception.getMessage(), exception);
                System.exit(1);
            }
        }
        DisplayManager.printLineBreak();
        arrayLength = DisplayManager.getLength(LENGTH_BOUND);
    }

    private static void process() {
        sorter0Type = SORTER_TYPES[sorter0];
        input = SortManager.getRandomArray(arrayLength, ARRAY_BOUND);
        Sorter sorter0 = SorterFactory.getSorter(sorter0Type);
        long startTime0;
        long endTime0;
        int[] result0;
        startTime0 = System.nanoTime();
        result0 = sorter0.sort(input);
        endTime0 = System.nanoTime();
        executionTime0 = (endTime0 - startTime0) / 1_000.0;
        if (mode == 1) {
            sorter1Type = SORTER_TYPES[sorter1];
            Sorter sorter1 = SorterFactory.getSorter(sorter1Type);
            long startTime1;
            long endTime1;
            int[] result1;
            startTime1 = System.nanoTime();
            result1 = sorter1.sort(input);
            endTime1 = System.nanoTime();
            executionTime1 = (endTime1 - startTime1) / 1_000.0;
            if (!Arrays.equals(result0, result1)) {
                try {
                    throw new SortException(
                            "One of the sorting algorithms is incorrect.");
                } catch (SortException exception) {
                    LOGGER.warn(exception.getMessage(), exception);
                }
            }
        }
        result = result0;
    }

    private static void output() {
        DisplayManager.printOutput0(input,
                sorter0Type.toString().toLowerCase().replace("_", " "), result,
                executionTime0);
        if (mode == 1) {
            DisplayManager.printOutput1(
                    sorter1Type.toString().toLowerCase().replace("_", " "),
                    executionTime1);
        } else if (mode != 0) {
            try {
                throw new ModeException("Mode cannot be " + mode);
            } catch (Exception exception) {
                exception.printStackTrace();
                LOGGER.fatal(exception.getMessage(), exception);
                System.exit(1);
            }
        }
    }

}
