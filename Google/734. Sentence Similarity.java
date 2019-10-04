class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1 == null && words2 == null) {
            return true;
        }   
        if (words1 == null || words2 == null) {
            return false;
        }
        if (words1.length != words2.length) {
            return false;
        }
        
        //有重复key会覆盖掉 用set记录values
        //Map<String, String> map = new HashMap<>();
        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> pair : pairs) {
            if (!map.containsKey(pair.get(0))) {
                map.put(pair.get(0), new HashSet<>());
            }
            if (!map.containsKey(pair.get(1))) {
                map.put(pair.get(1), new HashSet<>());
            }
            
            map.get(pair.get(0)).add(pair.get(1));
            map.get(pair.get(1)).add(pair.get(0));
            // System.out.println(pair.get(0));
            // System.out.println(pair.get(1));
        }
        
        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) {
                continue;
            } 
            if (!map.containsKey(words1[i]) || 
                !map.get(words1[i]).contains(words2[i])) {
                // System.out.println(words1[i]);
                // System.out.println(words2[i]);
                return false;
            } 
        }
        
        return true;
    }
}
