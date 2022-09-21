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
        return 0;
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
}
