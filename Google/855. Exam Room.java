class ExamRoom {
    int N;
    TreeSet<Integer> seats;
    public ExamRoom(int N) {
        this.N = N;
        seats = new TreeSet<>();
    }
    
    public int seat() {
        if (seats.size() == 0) {
            seats.add(0);
            return 0;
        }
        //left-most point
        int res = 0;
        int maxD = seats.first();
        Integer prev = null;
        
        for (int s : seats) {
            if (prev != null) {
                int dist = (s - prev) / 2;
                //System.out.println(dist);
                //打擂台
                if (dist > maxD) {
                    maxD = dist;
                    res = prev + dist;
                }
            } 
            prev = s;
        }
        
        //right-most point
        if (N - 1 - seats.last() > maxD) {
            res = N - 1;
        }
        
        seats.add(res);
        return res;
    }
    
    //O(logN)
    public void leave(int p) {
        seats.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
