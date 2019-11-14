class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if (S == null || S.length() == 0) {
            return "";
        }
        
        int n = indexes.length;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        
        //since indexes is not sorted, we need to sort it and save the position
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[] {indexes[i], i});
        }
        Collections.sort(list, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        for (int[] temp : list) {
            int start = temp[0];
            int i = temp[1];
            
            if (sources[i].equals(S.substring(start, start + sources[i].length()))) {
                sb.append(S.substring(index, start));
                sb.append(targets[i]);
                index = start + sources[i].length();
                //System.out.println(index);
            }
        }
        
        if (index < S.length()) {
            sb.append(S.substring(index, S.length()));
        }
            
        return sb.toString();
    }
}
