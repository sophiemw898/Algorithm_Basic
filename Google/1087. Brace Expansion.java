class Solution {
    public String[] expand(String S) {
        if (S == null || S.length() == 0) {
            return new String[] {""};
        }
        if (S.length() == 1) {
            return new String[] {S};
        }
        
        TreeSet<String> res = new TreeSet<>();
        
        if (S.charAt(0) == '{') {
            int i = 0;//track the first{}
            while (S.charAt(i) != '}') {
                i++;
            }
            String letters = S.substring(1, i);
            String[] letter = letters.split(",");
            String[] strs = expand(S.substring(i + 1));
            for (String curr : letter) {
                for (String str : strs) {
                    res.add(curr + str);
                }
            }
            
        } else {
            String[] strs = expand(S.substring(1));
            for (String str : strs) {
                res.add(S.charAt(0) + str);
            }
        }
        
        //return res.toArray(new String[0]);
        String[] ans = new String[res.size()];
        int index = 0;
        for (String str : res) {
            ans[index++] = str;
        }
        
        return ans;
    }
}
