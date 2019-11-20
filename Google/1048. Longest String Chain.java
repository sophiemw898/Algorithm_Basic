//dp之前需要排序   O（NlogNS) space O(NS)
class Solution {
    public int longestStrChain(String[] words) {
        if (words.length <= 1) {
            return words.length;
        }
        //world chain can be choose from words without the same order
        //need to sort the words first with shorter words listed first
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        
        int count = 0;
        int n = words.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(isValid(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    //System.out.println(words[i] + "'" + dp[i]);
                }
            }
            count = Math.max(count, dp[i]);
        }
        
        return count;
    }
    
    //chech is pre is a predecessor of cur "ab" -> "abc"
    private boolean isValid(String pre, String cur) {
        // char[] preChar = pre.toCharArray();
        // char[] curChar = cur.toCharArray();
        int p = 0;
        int c = 0;
        int count = 0;
        if (cur.length() - pre.length() != 1) {
            return false;
        }
        
        while (p < pre.length() && c < cur.length()) {
            if (pre.charAt(p) == cur.charAt(c)) {
                p++;
                c++;
            } else if (count == 1) {
                return false;
            } else {
                count++;
                c++;
            }
        }
        
        return true;
        //超时
        //for (int i = 0; i < cur.length(); i++) {
        //     if (pre.equals(cur.substring(0, i) + cur.substring(i + 1))) {
        //         return true;
        //     }
        // }
        // return false;
    }
}
