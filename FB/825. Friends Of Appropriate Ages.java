class Solution {
    public int numFriendRequests(int[] ages) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int age : ages) {
            if (count.containsKey(age)) {
                count.put(age, count.get(age) + 1);
            } else {
                count.put(age, 1);
            }
        }
        int res = 0;
        for (int i : count.keySet()) {
            for (int j : count.keySet()) {
                if (isValid(i, j)) {
                    if (i != j) {
                        res += count.get(i) * count.get(j);
                    } else {
                        res += count.get(i) * (count.get(j) - 1);
                    }
                }
            }
        }
        return res;
    }
    
    private boolean isValid (int a, int b) {
        if (b <= 0.5 * a + 7 || b > a || (b > 100 && a < 100)) {
            return false;
        }
        return true;
    }
}
