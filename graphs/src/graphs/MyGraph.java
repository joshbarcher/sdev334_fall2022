package graphs;

import adts.IWeightedUndirectedGraph;

import java.util.HashMap;
import java.util.Map;

public class MyGraph<V> implements IWeightedUndirectedGraph<V>
{
    private Map<V, Node> adjacencyLists = new HashMap<>();

    @Override
    public boolean addVertex(V element)
    {
        //the vertices are part of a set
        if (containsVertex(element))
        {
            return false;
        }

        //add it (the element and a null head reference in the LL)
        adjacencyLists.put(element, null);
        return true;
    }

    @Override
    public boolean addVertex(V... elements)
    {
        //only return true if all the elements were added
        boolean result = true;
        for (V element : elements)
        {
            boolean added = addVertex(element);
            result = result && added;
        }
        return result;
    }

    @Override
    public boolean addEdge(V first, V second, int weight)
    {
        //edges are part of a set (no duplicates)
        if (containsEdge(first, second))
        {
            return false;
        }

        //add the new edge at the start of both of the adjacency lists
        Node oldHeadFirst = adjacencyLists.get(first);
        Node oldHeadSecond = adjacencyLists.get(second);

        if (oldHeadFirst == null)
        {
            adjacencyLists.put(first, new Node(second, weight));
        }
        else
        {
            //put a new node at the start o fthe linked list
            adjacencyLists.put(first, new Node(second, weight, oldHeadFirst));
        }

        if (oldHeadSecond == null)
        {
            adjacencyLists.put(second, new Node(first, weight));
        }
        else
        {
            //put a new node at the start o fthe linked list
            adjacencyLists.put(second, new Node(first, weight, oldHeadSecond));
        }

        return true;
    }

    @Override
    public boolean containsVertex(V search)
    {
        return adjacencyLists.containsKey(search);
    }

    @Override
    public boolean containsEdge(V first, V second)
    {
        return false;
    }

    @Override
    public boolean removeVertex(V search)
    {
        return false;
    }

    @Override
    public boolean removeEdge(V first, V second)
    {
        return false;
    }

    @Override
    public int vertexSize()
    {
        return 0;
    }

    @Override
    public int edgeSize()
    {
        return 0;
    }

    @Override
    public int degree(V vertex)
    {
        return 0;
    }

    //inner classes
    private class Node
    {
        //data in the node
        private V otherVertex;
        private int weight;

        //next node
        private Node next;

        public Node(V otherVertex, int weight)
        {
            this.otherVertex = otherVertex;
            this.weight = weight;
        }

        public Node(V otherVertex, int weight, Node next)
        {
            this.otherVertex = otherVertex;
            this.weight = weight;
            this.next = next;
        }
    }
}

















