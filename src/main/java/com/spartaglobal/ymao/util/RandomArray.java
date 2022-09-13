package com.spartaglobal.ymao.util;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomArray {

    private static int[] input;
    private static int[] result;

    public static void initialise(int length, int bound) {
        input = getRandomArray(length, bound);
        result = Arrays.copyOf(input, length);
        Arrays.sort(result);
    }

    public static int[] getInput() {
        return input;
    }

    public static int[] getResult() {
        return result;
    }

    public static int[] getRandomArray(int length, int bound) {
        return IntStream.generate(()
                -> new Random().nextInt(bound)).limit(length).toArray();
    }

}
