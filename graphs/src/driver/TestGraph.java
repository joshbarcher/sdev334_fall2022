package driver;

import graphs.MyGraph;

import java.util.List;
import java.util.Map;

public class TestGraph
{
    public static void main(String[] args)
    {
        //create our test graph
        MyGraph<Character> charGraph = new MyGraph<>();

        charGraph.addVertex('A', 'B', 'C', 'D', 'E', 'F');
        charGraph.addEdge('A', 'B', 1);
        charGraph.addEdge('B', 'C', 1);
        charGraph.addEdge('C', 'D', 1);
        charGraph.addEdge('C', 'E', 1);
        charGraph.addEdge('C', 'F', 1);
        charGraph.addEdge('E', 'F', 1);

        Map<Character, Character> traversal = charGraph.dfs('C');
        System.out.println(traversal);

        Character current = 'E';
        while (current != null)
        {
            System.out.println(current);
            current = traversal.get(current);
        }
    }

    private static void firstGraphTests()
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

        System.out.println("|V| = " + stringGraph.vertexSize());
        System.out.println("|E| = " + stringGraph.edgeSize());
    }
}