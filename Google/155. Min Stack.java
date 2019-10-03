class MinStack {
    
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }
    
    //每次push进的值是最小值的时候，把原最小值先寸进去，这样pop时候有记录
    public void push(int x) {
        
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    
    //如果pop出来的值是最小值，则更新min为此小值
    public void pop() {
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
