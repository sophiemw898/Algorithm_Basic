//Store two sorted lists of intervals: 
//one list will be all times that are at least single booked, 
//and another list will be all times that are definitely double booked. 
//If none of the double bookings conflict, then the booking will succeed, and you should update your single and double bookings accordingly.

class MyCalendarTwo {

    List<int[]> map1;
    List<int[]> map2;
    public MyCalendarTwo() {
        map1 = new ArrayList<>();
        map2 = new ArrayList<>();
    }
    
    int i = 0;
    public boolean book(int start, int end) {
        //check the double bookings conflict
        for (int[] event : map2) {
            if (event[0] < end && event[1] > start) {
                return false;
            }
        }
        updateCalendar(start, end);
        return true;
    }
    
    //update both lists
    private void updateCalendar(int start, int end) {
        for (int[] event : map1) {
            if (event[0] < end && event[1] > start) {
                map2.add(new int[] {Math.max(event[0], start), Math.min(event[1], end)});   
            }
        }
        
        map1.add(new int[] {start, end});
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
