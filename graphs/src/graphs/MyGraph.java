package graphs;

import adts.IGraph;
import org.w3c.dom.Node;

import java.util.*;

public class MyGraph<V> implements IGraph<V>
{
    private Map<V, Node> adjacencyLists = new HashMap<>();
    private int edgeCount = 0;

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

        addDirectedEdge(first, second, weight);
        addDirectedEdge(second, first, weight);
        edgeCount++;

        return true;
    }

    private void addDirectedEdge(V first, V second, int weight)
    {
        Node oldHead = adjacencyLists.get(first);
        if (oldHead == null)
        {
            adjacencyLists.put(first, new Node(second, weight));
        }
        else
        {
            //put a new node at the start o fthe linked list
            adjacencyLists.put(first, new Node(second, weight, oldHead));
        }
    }

    @Override
    public boolean containsVertex(V search)
    {
        return adjacencyLists.containsKey(search);
    }

    @Override
    public boolean containsEdge(V first, V second)
    {
        //preconditions? - make sure the vertices are in the graph
        if (containsVertex(first) && containsVertex(second))
        {
            //step #1 - get the adjacency list of first
            Node current = adjacencyLists.get(first);

            //step #2 - loop over the list and look for second in the list
            while (current != null)
            {
                if (current.otherVertex.equals(second))
                {
                    return true;
                }
                current = current.next;
            }
        }
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
        //step #1 - double check that the vertices are in the graph
        //step #2 - remove directed edge (first, second)
        //step #3 - remove directed edge (second, first)
        //step #4 - TODO decrement the edge count!

        return false;
    }

    @Override
    public Set<V> vertices()
    {
        return adjacencyLists.keySet();
    }

    @Override
    public Set<Edge<V>> edges()
    {
        return null;
    }

    @Override
    public int vertexSize()
    {
        //the same as the number of keys in the map
        return adjacencyLists.size();
    }

    @Override
    public int edgeSize()
    {
        return edgeCount;
    }

    @Override
    public List<V> dfs(V source)
    {
        if (vertices().isEmpty())
        {
            return new ArrayList<>();
        }

        List<V> traversalResults = new ArrayList<>();
        Set<V> visitedVerts = new HashSet<>();

        dfsRecursive(source, traversalResults, visitedVerts);

        return traversalResults;
    }

    //a list for our results - maintains the traversal order
    //a set for determining what we've seen already - fast!
    private void dfsRecursive(V current, List<V> traversal, Set<V> visited)
    {
        //only traverse to this vertex if I haven't seen it before
        if (!visited.contains(current))
        {
            //mark that we have visited this vertex
            traversal.add(current);
            visited.add(current);

            //try to visit adjacent vertices
            Node neighbor = adjacencyLists.get(current);
            while (neighbor != null)
            {
                //visit this neighbor
                dfsRecursive(neighbor.otherVertex, traversal, visited);

                //then move on the the next
                neighbor = neighbor.next;
            }
        }
    }

    @Override
    public List<V> bfs(V source)
    {
        return null;
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

















