package com.spartaglobal.ymao.controller;

import java.util.Random;
import java.util.stream.IntStream;

public class SortManager {

    public static int[] getRandomArray(int length, int bound) {
        return IntStream.generate(()
                -> new Random().nextInt(bound)).limit(length).toArray();
    }

}
