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
    }
}