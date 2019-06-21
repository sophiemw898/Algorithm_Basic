class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        
        List<int[]> res = new ArrayList<>();
        
        //sort the intervals with smaller start first
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare (int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        int[] temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (temp[1] >= intervals[i][0]) {
                temp[1] = Math.max(temp[1], intervals[i][1]);
            } else {
                res.add(temp);
                temp = intervals[i];
            }
        }
        res.add(temp);
        
        return res.toArray(new int[res.size()][2]);
    }
}
