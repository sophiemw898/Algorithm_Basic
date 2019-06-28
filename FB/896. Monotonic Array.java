class Solution {
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length <= 1) {
            return true;
        }
        
        boolean isInc = A[1] >= A[0];
        boolean isDec = A[0] >= A[1];
        
        for (int i = 2; i < A.length; i++) {
            isInc &= A[i] >= A[i - 1];
            isDec &= A[i - 1] >= A[i];
            System.out.println(isDec);
        }
        
        return isInc || isDec;
    }
}
