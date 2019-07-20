class Solution {
    public int[] exclusiveTime(int n, List<String> logs) { 
        //use stack to record the order of point to go
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        
        //initializaiton
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int prev = Integer.parseInt(s[2]);//record the time of last status
        
        //travel all nodes one time
        int i = 1;
        while (i < logs.size()) {
            s = logs.get(i).split(":");
            int currUser = Integer.parseInt(s[0]);
            int currTime = Integer.parseInt(s[2]);
            if (s[1].equals("start")) {
                //update stack.peek() time
                if (!stack.empty()) {
                    res[stack.peek()] += currTime - prev;
                }
                stack.push(currUser);
                prev = currTime;
            } else {
                //single threaded!only one functionexecuted at a given time unit.
                res[stack.peek()] += currTime - prev + 1;
                stack.pop();
                prev = currTime + 1;
            }
            i++;
        }
        
        return res;
    }
}
