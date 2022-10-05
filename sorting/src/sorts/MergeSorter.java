package sorts;

public class MergeSorter
{
    private int[] auxArray;

    public void mergeSort(int[] array)
    {
        //is the array already sorted?
        if (array.length <= 1)
        {
            return; //already sorted!
        }

        //create the aux array for use in merge()
        auxArray = new int[array.length];

        mergeSort(array, 0, array.length - 1);
    }

    //hide the recursive implementation of merge sort
    //perform the divide & conquer?
    //divide - recursively split up the array until left & right sides are sorted
    //conquer - merge the left and right sorted sub-array
    private void mergeSort(int[] array, int low, int high)
    {
        //base case, the sub-array is one or less elements
        if (high - low <= 0)
        {
            System.out.println("Reached a base case: " + array[high]);
            return; //the sub-array is already sorted...
        }

        int mid = (low + high) / 2;

        //recursively sort the left and right sub-arrays
        mergeSort(array, low, mid); //sort the left
        mergeSort(array, mid + 1, high); //then we sort the right

        //merge
        merge(array, low, high);
    }

    private void merge(int[] array, int low, int high)
    {
        //TODO write the merge routine
    }
}










