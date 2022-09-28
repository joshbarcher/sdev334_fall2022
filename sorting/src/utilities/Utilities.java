package utilities;

import java.util.Random;

public class Utilities
{
    public static boolean containsInversions(int[] array)
    {
        //check adjacent elements for inversions
        for (int i = 0; i < array.length - 1; i++)
        {
            if (array[i] > array[i + 1])
            {
                return true;
            }
        }

        //we found no inversions!
        return false;
    }

    //generate an array of "arraySize" elements in the range [lowBound, highBound]
    public static int[] generateArray(int arraySize, int lowBound, int highBound)
    {
        int[] results = new int[arraySize];

        //generate random elements
        Random random = new Random();
        for (int i = 0; i < results.length; i++)
        {
            int randomNum = lowBound + random.nextInt(highBound - lowBound + 1);
            results[i] = randomNum;
        }

        return results;
    }

    public static void swap(int[] array, int firstIndex, int secondIndex)
    {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
