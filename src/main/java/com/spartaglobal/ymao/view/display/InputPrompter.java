package com.spartaglobal.ymao.view.display;

import com.spartaglobal.ymao.view.DisplayManager;

public class InputPrompter {

    public static void promptSorter() {
        DisplayManager.printLine("""
                Welcome to the sort manager application.
                Choose a sorting algorithm by entering its number option:
                0: bubble sort
                1: heapsort
                2: insertion sort
                3: merge sort
                4: quicksort
                5: selection sort
                6: tree sort""");
    }

    public static void promptInteger(int bound) {
        DisplayManager.printLine(
                "Please enter an integer between 0 and " + bound + ".");
    }

    public static void promptArrayLength() {
        DisplayManager.printLine("""
                Choose the length of the array to be generated.
                The length should be between 0 and 5,000.""");
    }

}
