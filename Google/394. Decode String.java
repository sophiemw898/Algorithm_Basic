class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        
        Stack<Integer> count = new Stack<>();
        Stack<String> str = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = 10 * num + s.charAt(i) - '0';
                    i++;
                }
                count.push(num);
            } else if (c == '[') {
                str.push(sb.toString());
                sb = new StringBuilder();
                i++;
            } else if(c == ']') {
                int num = count.pop();
                StringBuilder temp = new StringBuilder();
                temp.append(str.pop());
                while (num > 0) {
                    temp.append(sb.toString());
                    num--;
                }
                sb = temp;
                i++;
            } else {
                sb.append(c);
                i++;
            }
            
        }
        
        return sb.toString();
    }
}

//dfs
class Solution {
    public String decodeString(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            queue.offer(c);
        }
        
        return helper(queue);
    }
    
    private String helper(Queue<Character> queue) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (Character.isDigit(c)) {
                num = 10 * num + c - '0';
            } else if (c == '[') {
                String sub = helper(queue);
                while (num-- > 0) {
                    sb.append(sub);
                }
                num = 0;
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
