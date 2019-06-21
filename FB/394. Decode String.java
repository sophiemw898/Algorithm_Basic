class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        Stack<Integer> count = new Stack<>();
        Stack<String> str = new Stack<>();
        int index = 0;
        
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                int num = 0;
                while (Character.isDigit(s.charAt(index))) {
                    num = num * 10 + (s.charAt(index) - '0');
                    index++;
                }
                count.push(num);
            } else if (c == '[') {
                str.push(res.toString());
                res = new StringBuilder();
                index++;
            } else if (c == ']') {
                int repeat_times = count.pop();
                StringBuilder temp = new StringBuilder();
                //之前已经decode的string
                temp.append(str.pop());
                for (int i = 0; i < repeat_times; i++) {
                    temp.append(res);
                }
                res = temp;
                index++;
            } else {
                res.append(c);
                index++;
            }      
        }
        
        return res.toString();
    }
}
