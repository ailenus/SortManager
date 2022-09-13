package com.spartaglobal.ymao.util;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomArray {

    public static int[] getRandomArray(int length, int bound) {
        return IntStream.generate(()
                -> new Random().nextInt(bound)).limit(length).toArray();
    }

}
