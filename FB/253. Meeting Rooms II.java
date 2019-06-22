class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }   
        //已开始时间排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        //弹出最早的结束时间
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        
        int count = 0;
        //记录前面最早的结束时间min，新开始时间 > min, count不变，更新min；新开始时间<min，count++更新min
        for (int i = 0; i < intervals.length; i++) {
            if (!pq.isEmpty() && pq.peek()[1] <= intervals[i][0]) {
                pq.poll();
                pq.offer(intervals[i]);
            } else {
                count++;
                pq.offer(intervals[i]);
            }
        }
            
        return count;
    }
}
