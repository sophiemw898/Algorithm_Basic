class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        List<int[]> res = new ArrayList<>();
        res.add(new int[] {r0, c0});
        //{0, 1}, {1, 0}, {0, -1}, {-1, 0}; // east, south, west, north
        int[] dir = new int[] {0, 1, 0, -1, 0};
        
        int d = 0;
        int len = 0;// move <len> steps in the <d> direction
        while (res.size() < R * C) {
            // when move east or west, the length of path need plus 1 
            if (d == 0 || d == 2) {
                len++;
            }
            for (int i = 0 ; i < len; i++) {
                r0 += dir[d];
                c0 += dir[d + 1];
                if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C) {//check valid
                    res.add(new int[] {r0, c0});
                }
            }
            d = (d + 1) % 4;// turn to next direction
        }
        
        return res.toArray(new int[R * C][2]);
    }
}
