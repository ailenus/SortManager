package com.spartaglobal.ymao.view;

import com.spartaglobal.ymao.view.display.InputProcessor;
import com.spartaglobal.ymao.view.display.InputPrompter;
import com.spartaglobal.ymao.view.display.OutputPrinter;

public class DisplayManager {

    public static int getSorterChoice(int bound) {
        InputPrompter.promptSorter();
        return InputProcessor.inputInteger("Enter your choice: ", bound);
    }

    public static int getArrayLength(int bound) {
        InputPrompter.promptArrayLength();
        return InputProcessor.inputInteger("Enter length: ", bound);
    }

    public static void printOutput(int[] input, String sorterType, int[] result,
                                   long executionTime) {
        OutputPrinter.printOutput(input, sorterType, result, executionTime);

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
