//there are more discussion in solution
class Solution {
    public int shortestWay(String source, String target) {
        // boolean[] check = new boolean[26];
        // for (char c : source.toCharArray()) {
        //     check[c - 'a'] = true;
        // }
        int index = 0;
        int res = 0;
        
        while (index < target.length()) {
            //letter not included in source return -1
            // if(!check[target.charAt(i) - 'a']) {
            //     return -1;
            // }
            // while (index < source.length() && source.charAt(index) != target.charAt(i)) {
            //     index++;
            // }
            int oldIndex = index;
            for (int i = 0; i < source.length(); i++) {
                if (index < target.length() && source.charAt(i) ==  target.charAt(index)) {
                    index++;
                }
            }
            
            if (index == oldIndex) {
                return -1;
            }
            
            res++;
        }
        return res;
    }
}
