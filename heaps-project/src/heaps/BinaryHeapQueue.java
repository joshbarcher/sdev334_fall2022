package heaps;

public class BinaryHeapQueue implements IPriorityQueue
{
    private static final int INITIAL_HEAP_SIZE = 10;

    private int[] heap;
    private int size;
    private int nextAvailableIndex = 1;

    public BinaryHeapQueue()
    {
        heap = new int[INITIAL_HEAP_SIZE];
    }

    @Override
    public void insert(int element)
    {
        //add the new element to the tree (at the next available index)
        heap[nextAvailableIndex] = element;

        //swim (and adjust the ordering of elements)
        swim(nextAvailableIndex);

        nextAvailableIndex++;
        size++;
    }

    private void swim(int curIndex)
    {
        int parentIndex = curIndex / 2;
        while (parentIndex >= 1)
        {
            if(heap[parentIndex] > heap[curIndex])
            {
                //swap them!
                swap(parentIndex, curIndex);
            }
            else
            {
                break; //stop and short-circuit
            }

            //move to our new current and parent element
            curIndex = parentIndex;
            parentIndex = curIndex / 2;
        }
    }

    //this methods swaps index "first" and index "second" in our heap array
    private void swap(int firstIndex, int secondIndex)
    {
        int temp = heap[firstIndex];
        heap[firstIndex] = heap[secondIndex];
        heap[secondIndex] = temp;
    }

    @Override
    public int remove()
    {
        //save the value at the root (highest priority)
        int result = heap[1];

        //replace the value at the root
        heap[1] = heap[nextAvailableIndex - 1];
        heap[nextAvailableIndex] = 0;

        //sink and adjust our heap
        sink(1);

        //adjust our counters
        size--;
        nextAvailableIndex--;

        return result;
    }

    private void sink(int curIndex)
    {
        //sink as long as the current index has a child
        while (curIndex <= size / 2)
        {
            //indices of children
            int leftChildIndex = 2 * curIndex;
            int rightChildIndex = 2 * curIndex + 1;

            //find the smaller child
            int smallestChildIndex = leftChildIndex;
            //if there is a right child and it's smaller
            if (rightChildIndex < nextAvailableIndex &&
                heap[rightChildIndex] < heap[leftChildIndex])
            {
                smallestChildIndex = rightChildIndex;
            }

            //figure out whether a child is smaller
            if (heap[curIndex] > heap[smallestChildIndex])
            {
                swap(curIndex, smallestChildIndex);
            }
            else
            {
                break; //short-circuit if they are in order
            }

            //move to the smallest child and repeat our conditions
            curIndex = smallestChildIndex;
        }
    }

    @Override
    public int peek()
    {
        return 0;
    }

    @Override
    public int size()
    {
        return 0;
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }

    @Override
    public void clear()
    {

    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        // Bracket for array
        stringBuilder.append("[");

        for (int i = 0; i < heap.length; i++)
        {
            // Add element to string
            stringBuilder.append(heap[i]);

            // No comma for last element
            if (i != heap.length - 1)
            {
                stringBuilder.append(", ");
            }
        }

        // Bracket for array
        stringBuilder.append("]");

        // Return StringBuilder as a String
        return stringBuilder.toString();
    }
}
