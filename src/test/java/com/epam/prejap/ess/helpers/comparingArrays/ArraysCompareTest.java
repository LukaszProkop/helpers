package com.epam.prejap.ess.helpers.comparingArrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class ArraysCompareTest {

    //given
    @Test(dataProvider = "primitives")
    public void testPrimitiveArraysComparison(byte[] first, byte[] second, int expected) {
        //when
        int actual = Arrays.compare(first, second);

        //then
        assertEquals(actual, expected);
    }

    //given
    @Test(dataProvider = "objects")
    public void testObjectArraysComparison(Train[] first, Train[] second, int expected) {
        //when
        int actual = Arrays.compare(first, second);

        //then
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] primitives() {
        return new Object[][]{
                {new byte[]{'a', 'b', 'c'}, new byte[]{'b', 'e', 'f'}, -1},
                {new byte[]{'i', 'k', 'a'}, new byte[]{'h', 'x', 'w'}, 1},
                {new byte[]{'p', 'a', 'y'}, new byte[]{'p', 'a', 'y'}, 0}
        };
    }

    @DataProvider
    public Object[][] objects() {
        Train[] arrOne = {new Train(1), new Train(50), new Train(7)};
        Train[] arrTwo = {new Train(8), new Train(9), new Train(12)};
        Train[] arrThree = {new Train(85), new Train(63), new Train(7)};
        Train[] arrFour = {new Train(2), new Train(40), new Train(18)};
        Train[] arrFive = {new Train(69), new Train(30), new Train(57)};
        Train[] arrSix = {new Train(4), new Train(3), new Train(2)};
        return new Object[][]{
                {arrOne, arrTwo, -1},
                {arrThree, arrFour, 1},
                {arrFive, arrSix, 1}
        };
    }
}
