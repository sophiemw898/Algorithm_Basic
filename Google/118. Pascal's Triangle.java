class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> curr = new ArrayList<>();
            
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    curr.add(1);
                } else {
                    //System.out.println(i);
                    //System.out.println(j);
                    curr.add(res.get(i - 2).get(j - 1) + res.get(i - 2).get(j));
                    //System.out.println(curr);
                }
            }
            
            res.add(curr);
        }
        
        return res;
    }
}
