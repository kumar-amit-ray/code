/**
here are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where 
prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

@Leetcode - https://leetcode.com/problems/course-schedule/
@Youtube - https://www.youtube.com/watch?v=kXy0ABd1vwo
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
        return adjList;
    }

    private void detectDAG(int numCourses) {
        for (int i = 0; i<numCourses; i++) {
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
    }
}
