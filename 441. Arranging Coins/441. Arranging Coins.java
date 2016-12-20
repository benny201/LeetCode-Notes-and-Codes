public class Solution {
    public int arrangeCoins(int n) {
        if (n == 0) {
            return 0;
        }
        
        long longN = (long)n;
        long start = 1;
        long end = n;
        
        while (start + 1 < end) {
            long mid = start + (end - start)/2;
            long num = (mid + mid * mid)/2;
            if (num == longN) {
                return (int)mid;
            } else if (num > longN) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if((end + end * end)/2 <= longN) {
            return (int)end;
        }
        
        if ((start + start * start)/2 <= longN) {
            return (int)start;
        }
        
        return 0;
        
        
    }
}