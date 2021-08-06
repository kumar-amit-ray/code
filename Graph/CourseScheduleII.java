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
    
    private Map<Integer, List<Integer>> adjList = new HashMap();
    private Map<Integer, Integer> color = new HashMap();
    private Stack<Integer> stack = new Stack(); 
    private boolean isDag = true;
    final static int NOT_PROCESSED = 0;
    final static int PROCESSING = 1;
    final static int PROCESSED = 2;
    
    
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return result;
        }
        computeAdjList(numCourses, prerequisites);
        detectCycle(numCourses);
        if (!isDag) {
            return result;
        }
        int i =0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop(); 
        }
        return result;
    }
    
    private void computeAdjList(int numCourses, int[][] prerequisites) {
        for (int[] preReq : prerequisites) {
            int dest = preReq[1];
            int src = preReq[0];
            
            List l = adjList.getOrDefault(src, new ArrayList<Integer>());
            l.add(dest);
            adjList.put(src, l);
        }
        System.out.println(adjList);
    }
    
    private void detectCycle(int numCourses) {
        for (int i=0; i<numCourses; i++) {
            color.put(i, NOT_PROCESSED);
        }
        
        for (int i=0; i<numCourses; i++) {
            if (!isDag) {
                return;
            }
            dfs(i);
        }
    }
    
    private void dfs(int vertex) {
        if (!isDag || color.get(vertex) == PROCESSED) {
            return;
        }
        if (color.get(vertex) == PROCESSING) {
            isDag = false;
            return;
        }
        color.put(vertex, PROCESSING);
        if (adjList.containsKey(vertex)) {
            for (int edge : adjList.get(vertex)) {
                dfs(edge);
            }
        }
        color.put(vertex, PROCESSED);
        stack.push(vertex);
    }
    
    
}
