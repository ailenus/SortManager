package com.spartaglobal.ymao.view.display;

import com.spartaglobal.ymao.view.DisplayManager;

import java.util.Arrays;

public class OutputPrinter {

    public static void printOutput(int[] input, String sorterType,
                                   int[] result, long executionTime) {
        DisplayManager.printLine(
                "\nThe randomly generated array is as follows.");
        DisplayManager.printLine(Arrays.toString(input));
        DisplayManager.printLine("\nYour chosen sorting algorithm is "
                + sorterType + ".");
        DisplayManager.printLine("\nThe sorted array is as follows.");
        DisplayManager.printLine(Arrays.toString(result));
        DisplayManager.printLine("\nThe execution time is " + executionTime
                + " nanoseconds.\n");
    }

}
