class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (A[mid] > A[mid - 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        return A[start] > A[end] ? start : end;
    }
}
