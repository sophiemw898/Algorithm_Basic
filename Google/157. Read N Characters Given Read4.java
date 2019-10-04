/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int res = 0;
        char[] temp = new char[4];
        boolean isEnd = false;
        
        while (!isEnd && res < n) {
            int count = read4(temp);
            //System.out.println(temp);
            
            if (count < 4) {
                isEnd = true;
            }
            
            count = Math.min(count, n - res);
            //count can't be moved to for loop since res changes
            
            for (int i = 0; i < count; i++) {
                buf[res++] = temp[i];
                //System.out.println(temp[i]);
            }
        }
    
        return res;
    }
}
