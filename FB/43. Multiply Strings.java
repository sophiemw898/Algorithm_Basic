//
class Solution {
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        int carry = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int mul= (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = res[p2] + mul;
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }
        
        //0 0 1 0 2 3 get"1023
        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            if (sb.length() == 0 && num == 0) {
                continue;
            }
            sb.append(num);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

//first by myself 
//past 80% but can simply code
class Solution {
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        int carry = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int mul= (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                res[i + j + 1] += (carry + mul) % 10;
                carry = (carry + mul) / 10;
            }
            if (carry != 0) {
                res[i] += carry;
                carry = 0;
            }
        }
        
        for (int i = num1.length() + num2.length() - 1; i >= 1; i--) {
            if (res[i] >= 10) {
                res[i - 1] += res[i] / 10;
                res[i] %= 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int firstIndex = num1.length() + num2.length() - 1;
        for (int i = 0; i < num1.length() + num2.length(); i++) {
            if (res[i] != 0){
                firstIndex = i;
                break;
            }
        }
        //System.out.println(firstIndex);
        for (int i = firstIndex; i < num1.length() + num2.length(); i++) {
            sb.append(res[i]);
        }
        
        return sb.toString();
    }
}
