//straigtforward
class Solution {
    public int longestOnes(int[] A, int K) {
        
        int zeroCount = 0;
        int start = 0;
        int res = 0;
        
        for (int end = 0; end < A.length; end++) {
            if (A[end] == 0) {
                zeroCount++;
            }
            
            while (zeroCount > K) {
                if (A[start] == 0) {
                    zeroCount--;
                }
                start++;
            }
            
            res = Math.max(res, end - start + 1);
        }
        
        return res;
    }
}

//For each A[j], try to find the longest subarray.
//If A[i] ~ A[j] has zeros <= K, we continue to increment j.
//If A[i] ~ A[j] has zeros > K, we increment i.

class Solution {
    public int longestOnes(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }   
        
        int i = 0, j;
        for (j = 0; j < A.length; j++) {
            if (A[j] == 0) {
                K--;
            }
            if (K < 0 && A[i++] == 0) {
                K++;
                //System.out.println(i);
                //i++必须在括号里，因为即使==1 也要++ 继续往后找0
                //且找到最大之后继续往后+j，此时k<0 i也会随之+1 这样j - i始终维持最大值
            }
        }
        
        return j - i;
    }
}


