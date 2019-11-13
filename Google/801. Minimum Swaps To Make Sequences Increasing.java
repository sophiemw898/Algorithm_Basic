//A 1 3 5 4 9
//B 1 2 3 7 8

//A 1 3 5 7
//B 1 2 3 4
//count of swap

//there are two stages for the swap, do it or not
// res = min(swaplastindex, notswaplastindex)

class Solution {
    public int minSwap(int[] A, int[] B) {
        int[] swap = new int[A.length];
        int[] fix = new int[B.length];
        
        //initialization
        fix[0] = 0;
        swap[0] = 1;
        
        
        for (int i = 1; i < A.length; i++) {
            //check stasue
            boolean bothIncreasing = (A[i - 1] < A[i]) && (B[i - 1] < B[i]);
            boolean changeIncreasing = (A[i - 1] < B[i]) && (B[i - 1] < A[i]);
            
            if (bothIncreasing && changeIncreasing) {
                //case 1: both true, keep the min one
                fix[i] = Math.min(fix[i - 1], swap[i - 1]);
                swap[i] = Math.min(fix[i - 1], swap[i - 1]) + 1;
            } else if (bothIncreasing) {
                //case 2: order is right now. 1st keep i-1 i same; 2nd swap both i-1 and i
                fix[i] = fix[i - 1];
                swap[i] = swap[i - 1] + 1;
            } else {
                //case 3: order is not right mush swap. 1st i swap i-1 keep; 2nd i-1 swap i keep
                fix[i] = swap[i - 1];
                swap[i] = fix[i - 1] + 1;
            }
        }
        
        return Math.min(swap[A.length - 1], fix[A.length - 1]);
    }
}
