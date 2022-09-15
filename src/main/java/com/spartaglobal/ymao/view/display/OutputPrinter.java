package com.spartaglobal.ymao.view.display;

import com.spartaglobal.ymao.view.DisplayManager;

import java.util.Arrays;

public class OutputPrinter {

    public static void printOutput0(int[] input, String sorterType,
                                    int[] result, double executionTime) {
        DisplayManager.printLine(
                "\nThe randomly generated array is as follows.");
        DisplayManager.printLine(Arrays.toString(input));
        DisplayManager.printLine("\nThe sorted array is as follows.");
        DisplayManager.printLine(Arrays.toString(result));
        DisplayManager.printLine(
                "\nYour chosen sorting algorithm is " + sorterType + ".");
        DisplayManager.printLine("The execution time is " + executionTime +
                " microseconds.\n");
    }

    public static void printOutput1(String sorterType, double executionTime) {
        DisplayManager.printLine(
                "Your other chosen sorting algorithm is " + sorterType + ".");
        DisplayManager.printLine("The execution time is " + executionTime +
                " microseconds.\n");
    }

}
