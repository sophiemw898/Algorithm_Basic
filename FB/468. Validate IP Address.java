class Solution {
    public String validIPAddress(String IP) {
        if (isValidIPv4(IP)) {
            return "IPv4";
        } else if (isValidIPv6(IP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }
    
    private boolean isValidIPv4(String IP) {
        if (IP.length() > 17) {
            return false;
        }
        //System.out.println(IP.length());
        String[] strs = IP.split("\\.", -1);
        //System.out.println(strs.length);
        if (strs.length != 4) {
            return false;
        }
        for (String str : strs) {
            if (!isValid4(str)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isValid4(String str) {
        if (str.length() == 0 || str.length() > 3) {
            return false;
        }
        if (str.charAt(0) == '0' && str.length() > 1) {
            return false;
        }
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
            num = 10 * num + str.charAt(i) - '0';
        }
        
        if (num > 255) {
            return false;
        }
        return true;
    }
    
    private boolean isValidIPv6(String IP) {
        if (IP.length() > 39 || IP.length() < 15) {
            return false;
        }
        //System.out.println(IP.length());
        //IP.split(":"). 不包含结尾的空各  :2:3:4: 返回 “” 2 3 4 
        //IP.split(":", -1). 包含结尾的空各  :2:3:4: 返回 “” 2 3 4 ""
        String[] strs = IP.split(":", -1);
        System.out.println(strs.length);
        if (strs.length != 8) {
            return false;
        }
        for (String str : strs) {
            if (!isValid6(str)) {
                System.out.println(2);
                return false;
            }
        }
        return true;
    }
    
    //字母必须在a-f和A-F
    private boolean isValid6(String str) {
        if (str.length() == 0 || str.length() > 4) {
            return false;
        }
        //System.out.println(1);
        for (int i = 0; i < str.length(); i++) {
            if (!(Character.isDigit(str.charAt(i)) 
                || (str.charAt(i) >= ('a') && str.charAt(i) <= ('f'))
                || (str.charAt(i) >= ('A') && str.charAt(i) <= ('F')))) {
                //System.out.println(i);
                return false;
            }
        }
        
        return true;
    }
}
