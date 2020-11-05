import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Arrays.asList(0);

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] degree = new int[n];
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.add(i);// add leaf node to queue
            }
        }

        List<Integer> answer = null;
        while (!q.isEmpty()) {
            answer = new ArrayList<>();
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int edge = q.poll();
                answer.add(edge);
                for (int neighbor : graph.get(edge)) {
                    if (--degree[neighbor] == 1) {
                        q.add(neighbor);
                    }
                }
            }
        }

        return answer;
    }
}