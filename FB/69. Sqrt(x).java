//binary search
//BS find last number satisfy num * num < x
class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1, right = x;
        while (left + 1 < right) {
            int mid = left + (right - left) /2;
            if (mid > x / mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        return right < x / right ? right : left; 
    }
}

//i * i溢出
class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int i = 1;
        for (; i <= x; i++) {
            if (i > x/i) {
               break;
            } 
        }
        return i - 1;
    }
}
