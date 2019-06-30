class Solution {
    public boolean isHappy(int n) {
        //记录所有出现过的数字，重复出现就说明无限循环了
        Set<Integer> inloop = new HashSet<>();
        int sum; 
        while(!inloop.contains(n)) {
            inloop.add(n);
            sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            
            if (sum == 1) {
                return true;
            } else {
                n = sum;  
            }
        }
        return false;
    }
} 
