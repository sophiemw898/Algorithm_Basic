class Solution {
    public List<String> findStrobogrammatic(int n) {    
        return helper(n, n);
    }

    private List<String> helper(int n, int m) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            res.add("");
            return res;
        }
        if (n == 1) {
            res.add("1");
            res.add("0");
            res.add("8");
            return res;
        }
        
        List<String> list = helper(n - 2, m);
        // System.out.println(n);
        // System.out.println(m);
        
        for (String str : list) {
            
            //System.out.println(str);
            //不是最外层循环，可以加上00
            if (n != m) {
                res.add("0" + str + "0");
                
            }

            res.add("1" + str + "1");
            res.add("6" + str + "9");
            res.add("8" + str + "8");
            res.add("9" + str + "6");
        }
        
        return res;
    }
}
