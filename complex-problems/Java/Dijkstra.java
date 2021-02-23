/**
@Youtube - https://www.youtube.com/watch?v=XB4MIexjvY0&t=598s
 */

public class GraphNode {
    private int vertex;
    private Map<Integer, Integer> edges; // Destination vertex and weight

    public GraphNode(int vertex) {
        this.vertex = vertex;
        this.edges = new HashMap<>();
    }

    public int getVertex() {
        return vertex;
    }

    public Map<Integer, Integer> getEdges() {
        return edges;
    }

    public void setEdge(int vertex, int weight) {
        this.edges.put(vertex, weight);
    }

    public boolean isDirectlyConnectedVertex(int vertex) {
        return edges.containsKey(vertex);
    }

    public int getWeight(int vertex) {
        if (edges.containsKey(vertex)) {
            return edges.get(vertex);
        }
        return -1;
    }
}

public class Dijkstra {
    private Map<Integer, GraphNode> graph;

    public Dijkstra() {
        this.graph = new HashMap<>();
    }

    public void addVertex(int vertex) {
        if (!graph.containsKey(vertex)) {
            graph.put(vertex, new GraphNode(vertex));
        }
    }

    public void addEdge(int fromVertex, int toVertex, int weight) {
        if (!graph.containsKey(fromVertex) || !graph.containsKey(toVertex)) {
            throw new InvalidParameterException("both vertices must be present in the graph");
        }
        graph.get(fromVertex).setEdge(toVertex, weight);
    }

    /*
      Run Dijkstra shortest path algorithm from 'fromVertex' to all other vertices in the graph
     */
    public Map<Integer, Integer> runShortestPath(int fromVertex) {
        Map<Integer, Integer> result = new HashMap<>();
        if (!graph.containsKey(fromVertex)) {
            return result;
        }
        GraphNode fromNode = graph.get(fromVertex);
        for(Map.Entry<Integer, GraphNode> entry: graph.entrySet()) {
            if (entry.getKey() == fromVertex) {
                continue;
            }
            if(fromNode.isDirectlyConnectedVertex(entry.getKey())) {
                result.put(entry.getKey(), fromNode.getWeight(entry.getKey()));
            } else {
                result.put(entry.getKey(), Integer.MAX_VALUE);
            }
        }
        runRelaxation(fromVertex, result);

        return result;
    }

    private int getNextUnvisitedVertex(Map<Integer, Integer> shortestPath, Set<Integer> visited) {
       int minVertex = Integer.MAX_VALUE;
       for (Map.Entry<Integer, Integer> entry: shortestPath.entrySet()) {
           if (visited.contains(entry.getKey())) {
               continue;
           } else if(minVertex == Integer.MAX_VALUE) {
               minVertex = entry.getKey();
           } else if(shortestPath.get(entry.getKey()) < shortestPath.get(minVertex)){
               minVertex = entry.getKey();
           }
       }
       return minVertex;
    }

    private void runRelaxation(int startVertex, Map<Integer, Integer> shortestPath) {
        Set<Integer> visited = new HashSet<>();
        int nextVertex;
        while((nextVertex = getNextUnvisitedVertex(shortestPath, visited)) != Integer.MAX_VALUE) {
            visited.add(nextVertex);
            for (Map.Entry<Integer, Integer> entry : graph.get(nextVertex).getEdges().entrySet()) {
                if (entry.getKey() != startVertex) {
                    int currentWeight = shortestPath.get(entry.getKey());
                    int newWeight = (shortestPath.get(nextVertex) != Integer.MAX_VALUE)?shortestPath.get(nextVertex) + entry.getValue() : Integer.MAX_VALUE;
                    shortestPath.put(entry.getKey(), Math.min(currentWeight, newWeight));
                }
            }
        }
    }

    public static void main(String[] args) {
        Dijkstra d = new Dijkstra();
        for (int i=1; i<7; i++) {
            d.addVertex(i);
        }
        d.addEdge(1, 2,50);
        d.addEdge(1, 4,10);
        d.addEdge(1, 3,45);
        d.addEdge(2, 3,10);
        d.addEdge(3, 5, 30);
        d.addEdge(4, 5,15);
        d.addEdge(4, 1,10);
        d.addEdge(5, 2,20);
        d.addEdge(5, 3,35);
        d.addEdge(6, 5,3);

        System.out.println(d.runShortestPath(1));
    }
}
