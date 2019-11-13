//O(1) O(1)
//have constrains 0 <= arr1[i], arr2[i] <= 1000
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        
        int[] count = new int[1001];
        //save the count in map
        for (int num : arr1) {
            count[num]++;
        }
        
        int index = 0;
        //save res which shown in arr2
        for (int num : arr2) {
            while (count[num] > 0) {
                res[index++] = num;
                count[num]--; 
            }
        }
        
        //save res not in arr2
        //need sort for res
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                res[index++] = i;
                count[i]--;
            }
        }
        
        return res;
    }
}

//O(N) O(N)
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        //save the count in map
        for (int num : arr1) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }
        
        int index = 0;
        //save res which shown in arr2
        for (int num : arr2) {
            while (map.get(num) > 0) {
                res[index++] = num;
                map.put(num, map.get(num) - 1); 
            }
        }
        
        //save res not in arr2
        for (int num : map.keySet()) {
            while (map.get(num) > 0) {
                res[index++] = num;
                map.put(num, map.get(num) - 1);
            }
        }
        
        return res;
    }
}
