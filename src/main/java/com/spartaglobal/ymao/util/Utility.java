package com.spartaglobal.ymao.util;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Utility {

    private static int[] input;
    private static int[] result;

    public static void initialise(int length, int bound) {
        input = random(length, bound);
        result = Arrays.copyOf(input, length);
        Arrays.sort(result);
    }

    public static int[] getInput() {
        return input;
    }

    public static int[] getResult() {
        return result;
    }

    /**
     * Generates an array of random ints of length from 0 (inclusive) to bound
     * (exclusive).
     * @param length - an int specifying the length of the returned array
     * @param bound - an int specifying the upper bound (exclusive) of the
     * randomly generated ints inside the returned array
     * @return the array of randomly generated ints
     */
    public static int[] random(int length, int bound) {
        return IntStream.generate(()
                -> new Random().nextInt(bound)).limit(length).toArray();
    }

}
