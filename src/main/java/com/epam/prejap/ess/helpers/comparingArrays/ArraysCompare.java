package com.epam.prejap.ess.helpers.comparingArrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Presentation of comparing arrays using helper class method
 * {@link Arrays#compare(Comparable[], Comparable[])}.
 */
final class ArraysCompare {
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
        System.out.format("Result of the comparison two arrays when first one is lexicographically grater: %d\n",
                Arrays.compare(first, second));

        first = new int[]{1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0,};
        second = new int[]{0, 1, 1, 9, 5, 4, 0, 1, 1, 9, 5, 4, 0, 1, 1, 9, 5, 4, 0, 1, 1, 9, 5, 4,};

        /*
        Comparing first with second primitive type array lexicographically between given indexes,
        comparing subsequent indexes using Arrays.mismatch().
        Return -1 when first found element is smaller,
                1 when first found element is grater,
                0 when there is no mismatch

         Throws:
         IllegalArgumentException - if aFromIndex > aToIndex or if bFromIndex > bToIndex
         ArrayIndexOutOfBoundsException - if aFromIndex < 0 or aToIndex > a.length or if bFromIndex < 0 or bToIndex > b.length
         NullPointerException - if either array is null
         */
        System.out.format("Result of the comparison two arrays when first one (between given indexes) is lexicographically less: %d\n",
                Arrays.compare(first, 5, 10, second, 5, 10));


        Train[] firstObj = {new Train(1),
                new Train(4),
                new Train(2),
                new Train(3)
        };
        Train[] secondObj = {new Train(0),
                new Train(5),
                new Train(6),
                new Train(7)
        };

        /*
        Comparing first with second Object type array lexicographically using a specified comparator,
        comparing subsequent indexes using Arrays.mismatch().
        Return -1 when first found element is smaller,
                1 when first found element is grater,
                0 when there is no mismatch

        Throws:
        NullPointerException - if the comparator is null
         */
        System.out.format("Result of the comparison two Object arrays by id when first" +
                        " one is lexicographically grater: %d\n",
                Arrays.compare(firstObj, secondObj, new TrainById()));

        firstObj = new Train[]{new Train(0), new Train(2), new Train(4),
                new Train(6), new Train(8), new Train(10),
                new Train(12), new Train(14), new Train(16)
        };
        secondObj = new Train[]{new Train(1), new Train(3), new Train(5),
                new Train(7), new Train(9), new Train(11),
                new Train(13), new Train(15), new Train(17)
        };


        /*
        Comparing first with second Object type array lexicographically between given indexes using a specified comparator,
        comparing subsequent indexes using Arrays.mismatch().
        Return -1 when first found element is smaller,
                1 when first found element is grater,
                0 when there is no mismatch

         Throws:
         IllegalArgumentException - if aFromIndex > aToIndex or if bFromIndex > bToIndex
         ArrayIndexOutOfBoundsException - if aFromIndex < 0 or aToIndex > a.length or if bFromIndex < 0 or bToIndex > b.length
         NullPointerException - if either array is null
         */
        System.out.format("Result of the comparison two Object arrays by id when first" +
                        " one (between given indexes) is lexicographically less: %d\n",
                Arrays.compare(firstObj, 2, 5, secondObj, 2, 5, new TrainById()));
    }

}

/**
 * Train class with id.
 *@implNote Implements {@link Comparable} for comparing by id.
 */
final class Train implements Comparable<Train> {
    private final int id;

    public Train(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Train o) {
        return Integer.compare(this.getId(), o.getId());
    }
}

/**
 * Custom comparator, comparing Trains by id.
 * @see Train
 */
final class TrainById implements Comparator<Train> {
    @Override
    public int compare(Train o1, Train o2) {
        return o1.compareTo(o2);
    }
}
