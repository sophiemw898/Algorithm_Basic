//O(n) O(m)
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            int num = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                num += row.get(i);
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
        }
        
        int max = 0;
        for (int num : map.keySet()) {
            max = Math.max(max, map.get(num));
            //System.out.println(num);
            //System.out.println(min);
        }
        
        return wall.size() - max;
    }
}
