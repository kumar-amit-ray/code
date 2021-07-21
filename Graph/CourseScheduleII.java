/**
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites
where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is 
impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]

@Leetcode - https://leetcode.com/problems/course-schedule-ii/
@Youtube - https://www.youtube.com/watch?v=qe_pQCh09yU
 */
class Solution {
private static final int NOT_PROCESSED = 0;
    private static final int PROCESSING = 1;
    private static final int PROCESSED = 2;

    private Map<Integer, Integer> color = new HashMap<>();
    private Stack<Integer> stack = new Stack<>();
    private Map<Integer, List<Integer>> adjList;
    private boolean isDAG = true; // if this is a directed acyclic graph

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        init(numCourses, prerequisites);
        detectDAG(numCourses);
        return this.isDAG;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        init(numCourses, prerequisites);
        detectDAG(numCourses);
        if (!this.isDAG) {
            return new int[0];
        }
        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }

    private void init(int numCourses, int[][] prerequisites) {
        adjList = buildAdjList(numCourses, prerequisites);

        for (int i=0; i<numCourses; i++) {
            color.put(i, NOT_PROCESSED);
        }
    }

    private Map<Integer, List<Integer>> buildAdjList(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            int dest = prerequisite[0];
            int src = prerequisite[1];
            List<Integer> l = adjList.getOrDefault(src, new ArrayList<>());
            l.add(dest);
            adjList.put(src, l);
        }
        System.out.println("adjacency build complete...");
        return adjList;
    }

    private void detectDAG(int numCourses) {
        System.out.println("cycle detection...");
        for (int i = 0; i<numCourses; i++) {
            System.out.println("starting with node " + i);
            if (!this.isDAG) {
                return;
            }
            if (color.get(i) == NOT_PROCESSED) {
                dfs(i);
            }
        }
    }

    private void dfs(int vertex) {
        if (!isDAG || color.get(vertex) == PROCESSED) {
            return;
        }
        if (color.get(vertex) == PROCESSING) {
            this.isDAG = false;
            return;
        }
        color.put(vertex, PROCESSING);
        if (adjList.containsKey(vertex)) {
            for (int adjVertex : adjList.get(vertex)) {
                dfs(adjVertex);
            }
        }
        color.put(vertex, PROCESSED);
        stack.push(vertex);
    }
}
