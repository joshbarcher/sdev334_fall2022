package adts;

import graphs.Edge;

import java.util.List;
import java.util.Set;

public interface IGraph<V>
{
    boolean addVertex(V element);
    boolean addVertex(V... elements);
    boolean addEdge(V first, V second, int weight);
    boolean containsVertex(V search);
    boolean containsEdge(V first, V second);
    int vertexSize();
    int edgeSize();

    //implement these!
    boolean removeVertex(V search);
    boolean removeEdge(V first, V second);
    Set<V> vertices();
    Set<Edge<V>> edges();

    //traversal algorithms
    List<V> dfs(V source);
    List<V> bfs(V source);
}

