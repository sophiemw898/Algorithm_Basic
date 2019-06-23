// set count the number
// for i 0 -- n
//     for j : i -> n
//         if !set.contains num && set.size == k
//             max = math.max(max, j - i);
//             break;
//         else 
//             set.add(num)

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k <= 0) {
            return 0;
        }
        //map to record letter and its count
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
            } else {
                map.put(s.charAt(right), 1);
            }
            
            while (map.size() > k && left < right) {
                //max = Math.max(max, right - left);
                if (map.get(s.charAt(left)) == 1) {
                    map.remove(s.charAt(left));
                } else {
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                }
                left++;
            }
            
            max = Math.max(max, right - left + 1);
        }
        
        return max;
    }
}
