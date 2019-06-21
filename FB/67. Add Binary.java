//从尾部到头每一列相加，并处理进位
//  1 0 1 0
//  1 0 1 1
//------------
//1 0 1 0 1
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >=0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}

//这种int溢出了
class Solution {
    public String addBinary(String a, String b) {

        int num_a = 0;
        for (int i = 0; i < a.length(); i++) {
            num_a = 2 * num_a + a.charAt(i) - '0';
            System.out.println(num_a);
        }
        int num_b = 0;
        for (int i = 0; i < b.length(); i++) {
            num_b = 2 * num_b + b.charAt(i) - '0';
        }
        System.out.println(num_a);
        System.out.println(num_b);
        int res = num_a + num_b;
        System.out.println(res);
        if (res == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (res != 0) {
            sb.append(res % 2);
            res /= 2;
        }
        
        return sb.toString();
    }
}
