package com.spartaglobal.ymao.view.display;

import com.spartaglobal.ymao.view.DisplayManager;

public class InputPrompter {

    public static void promptMode() {
        DisplayManager.printLine("""
                
                Welcome to the sort manager application.
                Choose between the following two mode options:
                0: Choose an algorithm to sort an array
                1: Compare two algorithms to compare their running time
                """);
    }

    public static void promptSorter() {
        DisplayManager.printLine("""
                Choose a sorting algorithm by entering its number option:
                0: bubble sort
                1: heapsort
                2: insertion sort
                3: merge sort
                4: quicksort
                5: selection sort
                6: tree sort""");
    }

    public static void promptAnotherSorter() {
        DisplayManager.printLine("Choose another sorting algorithm.");
    }

    public static void promptInteger(int bound) {
        DisplayManager.printLine(
                "Please enter an integer between 0 and " + bound + ".");
    }

    public static void promptLength() {
        DisplayManager.printLine("""
                Choose the length of the array to be generated.
                The length should be between 0 and 5,000.""");
    }

}
