public class Solution {
    public int divide(int dividend_int, int divisor_int) {
        if (divisor_int == 0) {
            return Integer.MAX_VALUE;
        }
        
        
        //find the sign
        int sign = ((dividend_int <= 0 && divisor_int > 0) || (dividend_int >= 0 && divisor_int < 0)) ? -1 : 1;
        
        long dividend = Math.abs((long) dividend_int);
        long divisor = Math.abs((long) divisor_int);
        
        long muti_res = 0;
        
        // find the end position
        while (dividend >= divisor) {
            long muti = 1;
            long sum = divisor;
            while (sum + sum <= dividend) {
                sum += sum;
                muti += muti;
            }
            dividend -= sum;
            muti_res += muti;
        }
        
        //handle overflow
        if (muti_res > Integer.MAX_VALUE) {
            return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        
        return (int)(sign * muti_res);
        
        
    }
}
