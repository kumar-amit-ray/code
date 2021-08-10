public class Graph {
    private int numV;
    private Map<Integer, List<Integer>> edges;

    public Graph(int num) {
        this.numV = num;
        edges = new HashMap<>();
        for (int i=0; i<num; i++) {
            edges.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int src, int dst) {
        edges.get(src).add(dst);
    }

    public List<Integer> dfs(int start) {
        Map<Integer, Boolean> visited = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        dfs_recursive(start, visited, result);
        return result;
    }

    public List<Integer> bfs(int start) {
        Map<Integer, Boolean> visited = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited.put(start, true);
        while (!q.isEmpty()) {
            int v = q.poll();
            result.add(v);
            for (int cv : edges.get(v)) {
                if (!visited.containsKey(cv)) {
                    visited.put(cv, true);
                    q.add(cv);
                }
            }
        }
        return result;
    }

    private void dfs_recursive(int v, Map<Integer, Boolean> visited, List<Integer> result) {
        if (visited.containsKey(v)) {
            return;
        }
        visited.put(v, true);
        result.add(v);

        if (edges.containsKey(v)) {
            for (int edge : edges.get(v)) {
                dfs_recursive(edge, visited, result);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(g.dfs(2));
        System.out.println(g.bfs(2));
    }
}
