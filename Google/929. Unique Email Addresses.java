class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            String[] curr = email.split("@");
            sb.append(transfer(curr[0]));
            sb.append("@");
            sb.append(curr[1]);
            //System.out.println(sb.toString());
            set.add(sb.toString());
        }
        
        return set.size();
    }
    
    private String transfer(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '+') {
                break;
            }
            if (c == '.') {
                continue;
            }
            sb.append(c);
        }
        
        return sb.toString();
    }
}

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        
        for (String email : emails) {
            String[] curr = email.split("@");
            //System.out.println(curr[0]);
            if (curr[0].contains("+")) {
                curr[0] = curr[0].substring(0, curr[0].indexOf('+'));
            }
            curr[0] = curr[0].replace(".", "");
            //System.out.println(currt);
            //System.out.println(curr[0] + "@" + curr[1]);
            set.add(curr[0] + "@" + curr[1]);
        }
        
        return set.size();
    }
}
