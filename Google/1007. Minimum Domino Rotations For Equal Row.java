
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        int countA = 0;
        int countB = 0;
        //try A[0]
        for (int i = 0; i < n; i++) {
            if (A[i] != A[0] && B[i] != A[0]) {
                break;
            }
                
            if (A[i] != A[0]) {
                countA++;
            }
            if (B[i] != A[0]) {
                countB++;
            }
            if (i == n - 1) {
                return Math.min(countA, countB);
            }
        }
        
        countA = 0;
        countB = 0;
        //try B[0]
        for (int i = 0; i < n; i++) {
            if (A[i] != B[0] && B[i] != B[0]) {
                break;
            }
                
            if (A[i] != B[0]) {
                countA++;
            }
            if (B[i] != B[0]) {
                countB++;
            }
            if (i == n - 1) {
                return Math.min(countA, countB);
            }
        }     
        
        return -1;
    }
}
