class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //use map to recond one course and the course after it
        //use degree to recond 一个课程做了几个课程的prer
        //从入度为0 的点入手，不断更新入度为0 的点
        int[] degree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] course : prerequisites) {
            degree[course[0]]++;
            int key = course[1];
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(course[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;
        int[] order = new int[numCourses];
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            order[count] = curr;
            count++;

            if (map.containsKey(curr)) {
                for (int next : map.get(curr)) {
                    degree[next]--;
                    if (degree[next] == 0) {
                        queue.offer(next);
                    }
                }                
            }
        }
        
        if (count == numCourses) {
            return order;
        }
        
        return new int[0];
    }
}
