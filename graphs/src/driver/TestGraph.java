package driver;

import graphs.MyGraph;

public class TestGraph
{
    public static void main(String[] args)
    {
        String[] strings = {"a", "b", "c", "d", "e", "f"};
        MyGraph<String> stringGraph = new MyGraph<>();
        boolean allAdded = stringGraph.addVertex(strings);
        System.out.println("All vertices added? " + allAdded);

        //search for vertices
        for (String test : strings)
        {
            System.out.println("containsVertex(" + test + ") = " +
                    stringGraph.containsVertex(test));
        }
        System.out.println("containsVertex(g) = " +
                stringGraph.containsVertex("g"));

        stringGraph.addEdge("a", "b", 1);
        stringGraph.addEdge("a", "c", 1);
        stringGraph.addEdge("a", "e", 1);

        //test for edges that should be there
        System.out.println(stringGraph.containsEdge("a", "b"));
        System.out.println(stringGraph.containsEdge("b", "a"));
        System.out.println(stringGraph.containsEdge("a", "e"));
        System.out.println(stringGraph.containsEdge("c", "d"));
        System.out.println(stringGraph.containsEdge("b", "e"));
    }
}