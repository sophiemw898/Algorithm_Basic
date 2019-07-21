class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        
        //遇到map里有的 ++， 没有的 -- 用count记录== 0的个数 when count== s1.length() 返回
        int count = 0;
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            //更新最右边点 
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                
                if (map.get(c) == 0) {
                    count++;
                }                
            }

            
            //更新最左边点
            if (i >= s1.length()) {
                c = s2.charAt(i - s1.length());
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    
                    if (map.get(c) == 1) {
                        count--;
                    }                       
                }             
            }
            
            if (count == map.size()) {
                return true;
            }
        }
        
        return false;
    }
}
