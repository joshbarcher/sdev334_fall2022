package driver;

import sorts.BubbleSorter;
import utilities.Utilities;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        int[] testArray = Utilities.generateArray(1000000, 1, 1000000);
        //System.out.println("Before: " + Arrays.toString(testArray));
        BubbleSorter.sort(testArray);
        //System.out.println("After: " + Arrays.toString(testArray));

        String sorted = !Utilities.containsInversions(testArray) ? "Yes" : "No";
        System.out.println("Is the array sorted? " + sorted);
    }
}