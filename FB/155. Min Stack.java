class MinStack {
    
    int min;
    Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        //必须是有等号，不然
        //["MinStack","push","push","push","getMin","pop","getMin"]
        //[[],[0],[1],[0],[],[],[]]报错
        if (min >= x) {
            System.out.println(x);
            System.out.println(min);
            stack.push(min);//record last min
            min = x;
            
        } 
        stack.push(x);
    }
    
    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
