//timee Complexity: O(NlogN). The function f is called only O(logN) times, and each time does O(N) work.
class Solution {
    public int[] beautifulArray(int N) {
        List<Integer> res = new ArrayList<>();
        
        res.add(1);
        
        while (res.size() < N) {
            List<Integer> temp = new ArrayList<>();
            for (int num : res) {
                if (num * 2 - 1 <= N) {
                    temp.add(num * 2 - 1);
                }
            }
            for (int num : res) {
                if (num * 2 <= N) {
                    temp.add(num * 2);
                }
            }
            res = temp;
        }
        
        int[] ans = new int[N];
        int index = 0;
        for (int num : res) {
            ans[index++] = num;
        }
        
        return ans;
    }
}
