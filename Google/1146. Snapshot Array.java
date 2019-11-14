//O(N) get()
//O(logN) TreeMap
//O(N) get()
//O(logN) TreeMap
class SnapshotArray {

    TreeMap<Integer, Integer>[] map;
    int snap_id = 0;
    public SnapshotArray(int length) {
        map = new TreeMap[length];
        //initialization
        for (int i = 0; i < length; i++) {
            map[i] = new TreeMap<>();
            map[i].put(0, 0);
        }
    }
    
    public void set(int index, int val) {
        map[index].put(snap_id, val);
    }
    
    public int snap() {
        return snap_id++;
    }
    
    public int get(int index, int snap_id) {
        // while (snap_id >= 0) {
        //     if (map[index].containsKey(snap_id)) {
        //         return map[index].get(snap_id);
        //     }
        //     snap_id--;
        // }
        
        // return 0;
        
        // return map[index].floorKey(snap_id) == null ? 
        //     0 : map[index].get(map[index].floorKey(snap_id));
        
        return map[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */


class SnapshotArray {

    Map<Integer, Integer>[] map;
    int snap_id = 0;
    public SnapshotArray(int length) {
        map = new HashMap[length];
        //initialization
        for (int i = 0; i < length; i++) {
            map[i] = new HashMap<>();
            map[i].put(0, 0);
        }
    }
    
    public void set(int index, int val) {
        map[index].put(snap_id, val);
    }
    
    public int snap() {
        return snap_id++;
    }
    
    public int get(int index, int snap_id) {
        while (snap_id >= 0) {
            if (map[index].containsKey(snap_id)) {
                return map[index].get(snap_id);
            }
            snap_id--;
        }
        
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
