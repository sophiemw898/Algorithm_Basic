class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        
        List<List<int[]>> graph = new ArrayList<>(N + 1);
        for(int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for(int[] time : times) graph.get(time[0]).add(new int[]{time[1], time[2]});
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        
        pq.offer(new int[]{K, 0});
        
        //Set<Integer> visited = new HashSet<>();
        boolean[] visited = new boolean[N + 1];
        
        int dist = 0;
        
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            //if(visited.contains(curr[0])) continue;
            if (visited[curr[0]]) {
                continue;
            }
            visited[curr[0]] = true;
            N--;
            dist = curr[1];
            for(int[] neighbor : graph.get(curr[0])) {
                if(!visited[neighbor[0]]) {
                    pq.offer(new int[]{neighbor[0], neighbor[1] + curr[1]});
                }
            }
        }
        //return visited.size() == N ? dist : -1;
        return 0 == N ? dist : -1;
    }
}
