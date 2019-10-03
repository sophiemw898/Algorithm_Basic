class Solution {
    public int repeatedStringMatch(String A, String B) {
        int q = 0;
        StringBuilder sb = new StringBuilder();
        for (; sb.length() < B.length(); q++) {
            sb.append(A);
        }
        if (sb.indexOf(B) >= 0) {
            return q;
        }
        if (sb.append(A).indexOf(B) >= 0) {
            return q + 1;
        }
        return -1;
    }
}
