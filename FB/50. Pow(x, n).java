class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return (double)1;
        }
        
        //boolean isNeg = false;
        Long N = (long)n;
        if (n < 0) {
            x = 1/x;
            //isNeg = true;
            //n = -n - 1;
            N = -N;
        }
        
        double power = 1;
        double temp = x;
        while (N > 0) {
            if (N % 2 == 1) {
                power *= temp;
            }
            temp = temp * temp;
            N /= 2;
        }
        
        // if (isNeg) {
        //     power *= x;
        // }
        return power;
    }
}

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return (double)1;
        }
        boolean isNeg = false;
        if (n < 0) {
            x = 1/x;
            isNeg = true;
            n = -n - 1;
        }
        
        double power = 1;
        double temp = x;
        while (n > 0) {
            if (n % 2 == 1) {
                power *= temp;
            }
            temp = temp * temp;
            n /= 2;
        }
        
        if (isNeg) {
            power *= x;
        }
        return power;
    }
}
