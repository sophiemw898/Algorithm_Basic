class Solution {
    public boolean confusingNumber(int N) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        
        int oldN = N;
        int newN = 0;
        while (N != 0) {
            int digit = N % 10;
            if (!map.containsKey(digit)) {
                return false;
            }
            newN = 10 * newN + map.get(digit);
            N /= 10;
        }
        
        return newN != oldN;
    }
}
