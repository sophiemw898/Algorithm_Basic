class Data {
    String val;
    int time;
    
    public Data(String val, int time) {
        this.time = time;
        this.val = val;
    }
}
class TimeMap {
    
    Map<String,List<Data>> map;
    
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<String, List<Data>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<Data>());
        }
        map.get(key).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        } else {
            //find the largest num <= timestamp in the list
            return binarySearch(map.get(key), timestamp);
        }
    }
    
    //find the largest num <= timestamp in the list
    private String binarySearch(List<Data> list, int timestamp) {
        int start = 0;
        int end = list.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (list.get(mid).time == timestamp) {
                return list.get(mid).val;
            } else if (list.get(mid).time > timestamp) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (list.get(end).time <= timestamp) {
            return list.get(end).val;
        }
        if (list.get(start).time <= timestamp) {
            return list.get(start).val;
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
