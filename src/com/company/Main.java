package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Integer[] array = new Integer[] {1, 2, 3, 4, 5, 3, 5, 6, 3, 5};
        System.out.println(Arrays.toString(func2(array, 2)));
    }

    private static int[] func(final int[] array, int n) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i: array) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        return map.entrySet().stream()
                .filter(entry -> entry.getValue() > n)
                .mapToInt(Entry::getKey)
                .toArray();
    }

    private static int[] func2(final Integer[] array, int n) {
        return Arrays.stream(array)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > n)
                .mapToInt(Entry::getKey)
                .toArray();
    }

}