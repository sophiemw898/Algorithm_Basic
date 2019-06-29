class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        String result = "";
        while (num != 0) {
            result = map[(num & 15)] + result; //&15 1111 转化为最后四位的十进制写法
            System.out.println(num & 15);
            num = num >>> 4;
            System.out.println(num);
        }
        
        return result;
    }
}
