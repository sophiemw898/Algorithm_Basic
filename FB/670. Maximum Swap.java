//O(n)
//For each position, we check whether there exists a larger digit in this num (start from 9 to current digit). We also need to make sure the position of this larger digit is behind the current one. 
//If we find it, simply swap these two digits and return the result.
class Solution {
    public int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        
        //Use last[] to record the last position of digit 0 ~ 9 in this num.
        for (int i = 0; i < A.length; i++) {
            last[A[i] - '0'] = i;
        }
        
        //we check whether there exists a larger digit in this num (start from 9 to current digit) behind current digit
        for (int i = 0; i < A.length; i++) {
            for (int k = 9; k > A[i] - '0'; k--) {
                if (last[k] > i) {
                    char temp = A[i];
                    A[i] =  A[last[k]];
                    A[last[k]] = temp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        
        return num;
    }
}

//brute force  O(n^3)
class Solution {
    public int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
        char[] ans = Arrays.copyOf(A, A.length);
        
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                //先交换
                char temp = A[j];
                A[j] = A[i];
                A[i] = temp;
                //再比较更新
                for (int index = 0; index < A.length; index++) {
                    if (A[index] == ans[index]) {
                        continue;
                    }
                    if (A[index] < ans[index]) {
                        break;
                    }
                    if (A[index] > ans[index]) {
                        ans = Arrays.copyOf(A, A.length);
                        break;
                    }
                }
                //再换回来
                A[i] = A[j];
                A[j] = temp;
            }
        }
        
        return Integer.valueOf(new String(ans));
    }
}
