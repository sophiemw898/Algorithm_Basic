//two pointers O(N)
class Solution {
    public int[] sortedSquares(int[] A) {
        int[] square = new int[A.length];
        
        int pos = 0;
        while (pos < A.length && A[pos] < 0) {
            pos++;
        }
        int neg = pos - 1;
        
        int index = 0;
        while (pos < A.length && neg >= 0) {
            if (A[pos] * A[pos] < A[neg] * A[neg]) {
                square[index++] = A[pos] * A[pos];
                pos++;
            } else {
                square[index++] = A[neg] * A[neg];
                neg--;
            }
        }
        //全是正数或者负数则直接进入下面循环
        while (neg >= 0) {
            square[index++] = A[neg] * A[neg];
            neg--;
        }
        while (pos < A.length) {
            square[index++] = A[pos] * A[pos];
            pos++;
        }
        
        return square;
    }
}

//sort O(NlogN)
class Solution {
    public int[] sortedSquares(int[] A) {
        int[] square = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            square[i] = A[i] * A[i];
        }
        
        Arrays.sort(square);
        return square;
    }
}
