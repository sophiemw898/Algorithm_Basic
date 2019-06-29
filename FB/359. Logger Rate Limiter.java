class Logger {
    // String message;
    // int timestamp;
    // Logger(String message, int timestamp) {
    //     this.message = message;
    //     this.timestamp = timestamp;
    // }
    
    Map<String, Integer> map;
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        //map必须放在外面 不然每次都更新map啊！！！！
        //Map<String, Integer> map = new HashMap<>();
        if (map.containsKey(message) && timestamp < (map.get(message) + 10)) {
            return false;
        }
        map.put(message, timestamp);
        
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */

