class Solution {
    public int calculateTime(String keyboard, String word) {
        int pre = 0;
        int res = 0;
        
        // //这样写每个字母都要找一遍，可以存下来以后直接调用
        // for (int i = 0; i < word.length(); i++) {
        //     int index = keyboard.indexOf(word.substring(i, i + 1));
        //     //System.out.println(index);
        //     res += Math.abs(index - pre);
        //     pre = index;
        // }
        
        int[] loc = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            loc[keyboard.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < word.length(); i++) {
            res += Math.abs(loc[word.charAt(i) - 'a'] - pre);
            pre = loc[word.charAt(i) - 'a'];
        }
        
        return res;
    }
}
