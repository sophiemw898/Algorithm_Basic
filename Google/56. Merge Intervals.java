class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        List<int[]> res = new ArrayList<>();
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                res.add(new int[] {start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                end = Math.max(end, intervals[i][1]);
            }
        }
        
        res.add(new int[] {start, end});
        
        // int len = res.size();
        // int[][] result = new int[len][2];
        // for (int i = 0; i < len; i++) {
        //     result[i] = res.get(i);
        // }
        
        //return result;
        
        return res.toArray(new int[res.size()][2]);
    }
}
