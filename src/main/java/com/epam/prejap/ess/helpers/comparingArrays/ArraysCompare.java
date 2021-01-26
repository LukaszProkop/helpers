package com.epam.prejap.ess.helpers.comparingArrays;

import java.util.Arrays;

public class ArraysCompare {
    public static void main(String[] args) {
        int[] first = {1, 0, 0, 0};
        int[] second = {0, 1, 1, 9, 5, 4};

        /*
        Comparing first with second primitive type array lexicographically,
        comparing subsequent indexes using Arrays.mismatch().
        Return -1 when first found element is smaller,
                1 when first found element is grater,
                0 when there is no mismatch
         */
        System.out.format("Result of the comparison two array when first one is lexicographically grater: %d\n",
                Arrays.compare(first, second));

        first = new int[]{1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0,};
        second = new int[]{0, 1, 1, 9, 5, 4, 0, 1, 1, 9, 5, 4, 0, 1, 1, 9, 5, 4, 0, 1, 1, 9, 5, 4,};


        /*
        Comparing first with second primitive type array lexicographically between given indexes,
        comparing subsequent indexes using Arrays.mismatch().
        Return -1 when first found element is smaller,
                1 when first found element is grater,
                0 when there is no mismatch
         */
        System.out.format("Result of the comparison two array when first one (between given indexes) is lexicographically less: %d\n",
                Arrays.compare(first, 5, 10, second, 5, 10));
    }
}
