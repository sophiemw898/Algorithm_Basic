class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] res = new int[queries.length];
        int[] counts = new int[words.length];
        
        for (int i = 0; i < counts.length; i++) {
            counts[i] = count(words[i]);
        }
        // //O(n^2)
        // for (int i = 0; i < queries.length; i++) {
        //     int cur = count(queries[i]);
        //     for (int j = 0; j < counts.length; j++) {
        //         if (cur < counts[j]) {
        //             res[i]++;
        //         }
        //     }
        // }
        //binary search O(nlogn)
        //find first > cur value
        Arrays.sort(counts);
        for (int i = 0; i < queries.length; i++) {
            int cur = count(queries[i]);
            int start = 0;
            int end = counts.length - 1;
            while (start + 1 < end) {
                int mid = start + (end - start)/2;
                if (counts[mid] > cur) {
                    end = mid;
                } else {
                    start = mid;
                }
            }

            if (counts[start] > cur) {
                res[i] = counts.length - start;
            } else if (counts[end] > cur) {
                res[i] = counts.length - end;
            } else {
                res[i] = 0;
            }
            
            // System.out.println(start);
            // System.out.println(end);
            // System.out.println(res[i]);
        }
        
        return res;
    }
    
    private int count(String str) {
        int res = 1;
        char c = str.charAt(0);
        
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) < c) {
                res = 1;
                c = str.charAt(i);
            } else if (str.charAt(i) == c) {
                res++;
            }
        }
        
        return res;
    }
}
