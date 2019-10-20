//Nlog(N) 用list寸不需要查包不包括curr[0] 不包裹就是null
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

//记录了每个点的最后步数 更快一点
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
        
        int[] minDis = new int[N + 1];
        Arrays.fill(minDis, Integer.MAX_VALUE);
        minDis[K] = 0;
        
        int dist = 0;
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            //if(visited.contains(curr[0])) continue;
            if (visited[curr[0]]) {
                continue;
            }
            visited[curr[0]] = true;
            N--;
            minDis[curr[0]] = curr[1];
            dist = curr[1];
            for(int[] neighbor : graph.get(curr[0])) {
                if(!visited[neighbor[0]] && neighbor[1] + curr[1] < minDis[neighbor[0]]) {
                    pq.offer(new int[]{neighbor[0], neighbor[1] + curr[1]});
                }
            }
        }
        //return visited.size() == N ? dist : -1;
        return 0 == N ? dist : -1;
    }
}

//用map  也记录了每个点的最后步数  每步要确认map.containsKey（）
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        
        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        boolean[] visited = new boolean[N + 1];
        //use this to recode all steps for each node
        int[] minDis = new int[N + 1];
        Arrays.fill(minDis, Integer.MAX_VALUE);
        minDis[K] = 0;
        
        pq.offer(new int[]{0, K});
        int max = 0;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[1];
            
            if (visited[currNode]) {
                continue;
            }
            visited[currNode] = true;
            
            int currDis = curr[0];
            minDis[curr[1]] = curr[0];
            
            max = currDis;
            N--;
            
            if (!graph.containsKey(currNode)) {
                continue;
            }
            //System.out.println(currNode);
            for (int[] next : graph.get(currNode)) {
                if (!visited[next[0]] && currDis + next[1] < minDis[next[0]]) {
                    pq.offer(new int[]{currDis + next[1], next[0]});
                }
            }
        }
        
        return N == 0 ? max : -1;
    }
}
