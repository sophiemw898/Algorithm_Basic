class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int i = S.length() - 1;
        int count = K;
        
        while (i >= 0) {
            count = K;
            while (count > 0 && i >= 0) {
                if (S.charAt(i) != '-') {
                    sb.append(Character.toUpperCase(S.charAt(i)));
                    count--;    
                }
                i--;
            }
            sb.append('-');
            
            while (i >=0 && S.charAt(i) == '-') {
                i--;
            }
        }
        
        return sb.reverse().toString().substring(1);
    }
}
