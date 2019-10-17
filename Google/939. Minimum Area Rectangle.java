//hashmap O(n2)
class Solution {
    public int minAreaRect(int[][] points) {
        if (points == null || points.length < 2) {
            return 0;
        }
        
        int res = Integer.MAX_VALUE;
        //sort by colomn
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            if (!map.containsKey(point[0])) {
                map.put(point[0], new HashSet<>());
            }
            map.get(point[0]).add(point[1]);
        }
        
        //any two points to form rectangle
        for (int[] p1 : points) {
            for(int[] p2 : points) {
                if (p1[0] == p2[0] || p1[1] == p2[1]) {
                    continue;
                }
                //find the other two points to keep the rectangle
                if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
                    res = Math.min(res, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
                }
            }
        }
        
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
