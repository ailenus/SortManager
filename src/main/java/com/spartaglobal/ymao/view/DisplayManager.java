package com.spartaglobal.ymao.view;

import com.spartaglobal.ymao.view.display.InputProcessor;
import com.spartaglobal.ymao.view.display.InputPrompter;
import com.spartaglobal.ymao.view.display.OutputPrinter;

public class DisplayManager {

    public static int getMode(int bound) {
        InputPrompter.promptMode();
        return InputProcessor.inputInteger("Enter your choice: ", bound);
    }

    public static int getSorter(int bound) {
        InputPrompter.promptSorter();
        return InputProcessor.inputInteger("Enter your choice: ", bound);
    }

    public static int getAnotherSorter(int bound) {
        InputPrompter.promptAnotherSorter();
        return InputProcessor.inputInteger("Enter your choice: ", bound);
    }

    public static void sameSorter() {
        printLine("You entered the same option. Please enter another option.");
    }

    public static int getLength(int bound) {
        InputPrompter.promptLength();
        return InputProcessor.inputInteger("Enter length: ", bound);
    }

    public static void printOutput0(int[] input, String sorterType, int[] result,
                                    double executionTime) {
        OutputPrinter.printOutput0(input, sorterType, result, executionTime);

    }

    public static void printOutput1(String sorterType, double executionTime) {
        OutputPrinter.printOutput1(sorterType, executionTime);
    }

    public static void print(String string) {
        System.out.print(string);
    }

    public static void printLine(String string) {
        System.out.println(string);
    }

    public static void printLineBreak() {
        System.out.println();
    }

}
