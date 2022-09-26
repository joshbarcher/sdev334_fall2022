package test;

import heaps.BinaryHeapQueue;

import java.util.PriorityQueue;

public class HeapDriver
{
    public static void main(String[] args)
    {
        BinaryHeapQueue priorityQueue = new BinaryHeapQueue();

        priorityQueue.insert(7);
        priorityQueue.insert(1);
        priorityQueue.insert(11);
        priorityQueue.insert(4);
        priorityQueue.insert(2);
        priorityQueue.insert(8);
        priorityQueue.insert(9);
        priorityQueue.insert(3);
        priorityQueue.insert(10);

        /*priorityQueue.insert(2);
        priorityQueue.insert(-9);
        priorityQueue.insert(-5);*/

        System.out.println(priorityQueue);

        //empty the queue
        while (!priorityQueue.isEmpty())
        {
            System.out.println(priorityQueue.remove());
        }
    }
}
