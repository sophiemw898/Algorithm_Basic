class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() < p.length()) {
            return res;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int count = map.size();
        int start = 0, end = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                count--;
                }
            }
            end++;
            
            while (count == 0) {
                if (end - start == p.length()) {
                    res.add(start);
                }
                char ch = s.charAt(start);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                    if (map.get(ch) > 0) {
                        count++;
                    }
                }
                
                start++;
            }   
        }
        
        return res;
    }
}

//超时
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() < p.length()) {
            return res;
        }
        
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (isValid(s.substring(i, i + p.length()), p)) {
                res.add(i);
            }
        }
        
        return res;
    }
    
    private boolean isValid(String t, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (char c : p.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            } else if (map.get(c) == 1) {
                map.remove(c);
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        
        return map.size() == 0;
    }
}
