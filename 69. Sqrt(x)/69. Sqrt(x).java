public class Solution {
    public int mySqrt(int xx) {
        if (xx == 0) {
            return 0;
        }
        
        long x = (long)xx;
        long start = 0;
        long end = x;
        
        while (start + 1 < end) {
            long mid = start + (end - start)/2;
            long square = mid * mid;
            if (square == x) {
                return (int)mid;
            } else if (square > x) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (end * end <= x) {
            return (int)end;
        }
        
        if (start * start <= x) {
            return (int)start;
        }
        
        return 0;
    }
}