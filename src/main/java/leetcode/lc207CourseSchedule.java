package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class lc207CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses]; // 每个index表示从哪个出发，index的arraylist包含所有到达的
        int[] in = new int[numCourses]; // 每个顶点的入度
        for (int i = 0; i < graph.length; ++i) {
            graph[i] = new ArrayList();
        }

        for (int[] p: prerequisites) {
            graph[p[1]].add(p[0]);
            in[p[0]]++;
        }
        Queue<Integer> q = new LinkedList();
        // for (int i : in) {
        //     if (i == 0) q.offer(i);
        // }
        for (int i = 0; i < numCourses; ++i) {
            if (in[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int pre = q.poll();
            for (int post : graph[pre]) {
                --in[post];
                if (in[post] == 0) q.offer(post);
            }
        }

        for (int i = 0; i < in.length; ++i) {
            if (in[i] != 0) return false;
        }
        return true;
    }
}