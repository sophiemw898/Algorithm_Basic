//TreeMap O(NlogN)
class MyCalendar {

    TreeMap<Integer, Integer> calendar;
    public MyCalendar() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start);
        Integer next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start)
            && (next == null || next >= end)) {
            calendar.put(start, end);
            return true;
        }
        
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */

//find the fist end > curr.start as next
//check curr.end <= next.start
//每加入一个event是O(N) N个event共需要O(N^2)时间
class MyCalendar {
    
    List<int[]> calendar;
    public MyCalendar() {
        calendar = new ArrayList<>();
    }

    //book 没有顺序。 可以【20，30】【10，15】
    public boolean book(int start, int end) {
        int i = 0;
        for (; i < calendar.size(); i++) {
            //find first event.end > start
            if (calendar.get(i)[1]> start) {
                break;
            }
        }
        
        if (i == calendar.size() || calendar.get(i)[0] >= end) {
            //将新的int[]直接按照顺序插入，则整个calendar有序
            calendar.add(i, new int[] {start, end});
            return true;
        }
       
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */

class MyCalendar {
    
    List<int[]> calendar;
    public MyCalendar() {
        calendar = new ArrayList<>();
    }

    //book 没有顺序。 可以【20，30】【10，15】
    public boolean book(int start, int end) {
        for (int[] event : calendar) {
            if (event[0] < end && event[1] > start) {
                return false;
            }
        }
        calendar.add(new int[] {start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
