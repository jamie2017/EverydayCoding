package BFS;

import java.util.*;

/**
 * Created by JMYE on 9/9/16.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        // Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stk = new Stack<>();
        int count=0;

        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        for(int i=0; i<prerequisites.length;i++){
            int course = prerequisites[i][0];
            int precourse = prerequisites[i][1];
            indegree[course]++;
            graph[precourse].add(course);
        }
        for (int i = 0; i < numCourses; i++) {
            // if(indegree[i] == 0) queue.offer(i);
            if (indegree[i] == 0) stk.push(i);
        }

        // while (!queue.isEmpty()) {
        while (!stk.isEmpty()) {
            // int course = queue.poll();
            int course = stk.pop();
            count++;
            List<Integer> adjacent = graph[course];
            if (adjacent == null) continue;
            for (int neighbor : adjacent) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    // queue.offer(neighbor);
                    stk.push(neighbor);
                }
            }

        }
        return count == numCourses;
    }
}
