package heaps;

//an interface for a binary min-heap
public interface IPriorityQueue
{
    //adt methods
    void insert(int element);
    int remove();
    int peek();

    //general methods
    int size();
    boolean isEmpty();
    void clear();
}
