//recursion
class Solution {
    private HashMap<Character, String> map;
    
    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        
        dfs("", digits, 0, res, map);
        return res;
    }
    
    private void dfs(String word, String digits, int index, List<String> res, HashMap<Character, String> map) {
        if (index == digits.length()) {
            res.add(word);
            return;
        }
        String letters = map.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            dfs(word + letters.charAt(i), digits, index + 1, res, map);
        }
    }
}
