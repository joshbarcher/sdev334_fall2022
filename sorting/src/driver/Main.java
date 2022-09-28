package driver;

import sorts.BubbleSorter;
import utilities.Utilities;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        int[] testArray = Utilities.generateArray(10, 1, 20);
        System.out.println("Before: " + Arrays.toString(testArray));
        BubbleSorter.sort(testArray);
        System.out.println("After: " + Arrays.toString(testArray));
    }
}