package com.spartaglobal.ymao.view.display;

import com.spartaglobal.ymao.view.DisplayManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputProcessor {

    public static int inputInteger(String prompt, int bound) {
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
        int input = -1;
        while (true) {
            DisplayManager.print(prompt);
            try {
                input = Integer.parseInt(bufferedReader.readLine());
            } catch (NumberFormatException exception) {
                InputPrompter.promptInteger(bound);
                continue;
            } catch (IOException exception) {
                exception.printStackTrace();
                System.exit(1);
            }
            if (input < 0 || input > bound) {
                InputPrompter.promptInteger(bound);
                continue;
            }
            break;
        }
        return input;
    }

}
