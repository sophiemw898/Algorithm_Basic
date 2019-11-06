//1 based and sorted result
package com.example.idea;

import java.util.*;

public class CriticalCircleAmazon {
    int time = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 1) {
            return res;
        }
        //use disc[] to store discovery times of visited vertices
        //if vertice i isn't visted, disc[i] will keep -1, which is the defalt value
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        //use low[] to store the lowest node id reachable from this node
        int[] low = new int[n + 1];

        //construct the graph
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> connection : connections) {
            graph[connection.get(0)].add(connection.get(1));
            graph[connection.get(1)].add(connection.get(0));
        }

        for (int i = 0; i <= n; i++) {
            if (dist[i] == -1) {
                dfs(i, res, graph, dist, low, i);
            }
        }

//        Collections.sort(res, new Comparator<List<Integer>>() {
//            public int compare (List<Integer> a, List<Integer> b) {
//                if (a.get(0) == b.get(0)) {
//                    return a.get(1) - b.get(1);
//                } else {
//                    return a.get(0) - b.get(0);
//                }
//            }
//        });

        return res;
    }

    private void dfs(int index, List<List<Integer>> res, List<Integer>[] graph,
                     int[] dist, int[] low, int parent) {
        // Initialize discovery time and low value
        dist[index] = low[index] = ++time;
        for (int neighbor : graph[index]) {
            //
            if (neighbor == parent) {
                continue;
            }
            if (dist[neighbor] == -1) {
                dfs(neighbor, res, graph, dist, low, index);
                // Check if the subtree rooted with v has a
                // connection to one of the ancestors of u
                low[index] = Math.min(low[index], low[neighbor]);

                // u - v is critical, there is no path for v to reach back to u or previous vertices of u
                if (low[neighbor] > dist[index]) {
                    res.add(Arrays.asList(index, neighbor));
                }

            } else {
                low[index] = Math.min(low[index], dist[neighbor]);
            }
        }
    }
}
