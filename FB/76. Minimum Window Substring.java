class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        //use map to record letters and count in t
        int countT = t.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        int countS = 0;
        int min = Integer.MAX_VALUE;
        String result = "";
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            //traverl j to find (i,j) include t
            while (j < s.length() && countS < countT) {
                char c = s.charAt(j);
                if (map.containsKey(c)) {
                    if(map.get(c) > 0) {
                        countS++;
                    }
                    map.put(c, map.get(c) - 1);
                }
                j++;
            }
            //in case j == s.length() no substing
            if (countS == countT) {
                if (min > j - i) {
                    min = j - i;
                    result = s.substring(i,j);
                }
            }
            //deal with i then go into i++ for loop
            char cc = s.charAt(i);
            if (map.containsKey(cc)) {
                if (map.get(cc) >= 0) {
                    countS--;
                }
                map.put(cc, map.get(cc) + 1);
            }
        }
        
        return result;
    }
}
