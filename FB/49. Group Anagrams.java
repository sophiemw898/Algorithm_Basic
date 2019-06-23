class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            if (!map.containsKey(String.valueOf(ch))) {
                map.put(String.valueOf(ch), new ArrayList<>());
            } 
        
            map.get(String.valueOf(ch)).add(s);
        }
        
        return new ArrayList(map.values());
        // for (String key : map.keySet()) {
        //     res.add(map.get(key));
        // }
        // return res;
    }
}
