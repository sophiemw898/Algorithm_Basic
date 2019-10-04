class MovingAverage {
    
    Queue<Integer> queue;
    int maxSize;
    Double sum = 0.0;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        maxSize = size;  
    }
    
    public double next(int val) {
        if (queue.size() >= maxSize) {
            sum -= queue.poll();
        }
        
        sum += val;
        queue.offer(val);
        
        return sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
