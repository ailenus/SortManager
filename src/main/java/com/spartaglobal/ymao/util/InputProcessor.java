package com.spartaglobal.ymao.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputProcessor {

    public static int inputInteger(String prompt, int bound)
            throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new
                InputStreamReader(System.in));
        int input = -1;
        while (true) {
            System.out.print(prompt);
            try {
                input = Integer.parseInt(bufferedReader.readLine());
            } catch (NumberFormatException exception) {
                System.out.println("Please enter an integer between 0 and "
                        + bound + ".");
                continue;
            }
            if (input < 0 || input > bound) {
                System.out.println("Please enter an integer between 0 and "
                        + bound + ".");
                continue;
            }
            break;
        }
        return input;
    }

}
