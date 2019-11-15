//same result saved or not 
//
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return res;
        }
        
        for (int i= 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> lefts = diffWaysToCompute(input.substring(0, i));
                List<Integer> rights = diffWaysToCompute(input.substring(i + 1));
                
                for (int left : lefts) {
                    for (int right : rights) {
                        int curr = 0;
                        // if (c == '+') {
                        //     curr = left + right;
                        // } else if (c == '-') {
                        //     curr = left - right;
                        // } else {
                        //     curr = left * right;
                        // }
                        switch(c) {
                            case '+' : curr = left + right;
                                break;
                            case '-' : curr = left - right;
                                break;
                            case '*' : curr = left * right;
                                break;
                        }
                        
                        res.add(curr);
                    }
                }
            }   
        }
        
        if(res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        
        return res;
    }
}
