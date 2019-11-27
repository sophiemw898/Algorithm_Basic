//Time Complexity: O(N + E), where NN is the number of rooms, and EE is the total number of keys.

//Space Complexity: O(N) in additional space complexity, to store stack and seen.
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        
        dfs(set, 0, rooms);
        
        return set.size() == rooms.size();
    }
    
    private void dfs(Set<Integer> set, int room, List<List<Integer>> rooms) {
        for (int key : rooms.get(room)) {
            if (!set.contains(key)) {
                set.add(key);
                dfs(set, key, rooms);
            }
        }
    }
}
