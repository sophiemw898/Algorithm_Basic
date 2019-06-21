class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = build(result);
            System.out.println(result);
        }
        return result;
    }
    
    private String build(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
;
        while (i < str.length()) {
            int count = 0;
            char c = str.charAt(i);
            while (i < str.length() && str.charAt(i) == c) {
                count++;
                i++;
            }
            sb.append(String.valueOf(count));
            sb.append(c);
        }
        
        return sb.toString();
    }
}
