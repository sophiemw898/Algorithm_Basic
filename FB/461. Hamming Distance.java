//还有超级简单的位移算法
class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        while (x != 0 && y != 0) {
            if (x % 2 != y % 2) {
                count++;
            }
            x = x/2;
            y = y/2;
        }
        
        while (x != 0) {
            if (x % 2 == 1) {
                count++;
            }
            x = x/2;
        }
        
        while (y != 0) {
            if (y % 2 == 1) {
                count++;
            }
            y = y/2;
        }
        return count;
    }
}
