class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if (points == null) {
            return null;
        }
        int[][] res = new int[K][2];
        if (K > points.length) {
            return points;
        }
        
        //pq sort from big to small;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                return (point2[0] * point2[0] + point2[1] * point2[1]) -
                        (point1[0] * point1[0] + point1[1] * point1[1]);
                }
        });
        
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        
        //now save smallest kth ans in pq
        //res 从大到小排列。需要从小到大排则index=--K
        int index = 0;
        while (index < K) {
            res[index++] = pq.poll();
        }
        
        return res;
    }
}
