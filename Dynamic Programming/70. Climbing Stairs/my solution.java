public class Solution {
    public int climbStairs(int n) {
        if (n < 0) {
            return 0;
        }
        
        if (n <= 1) {
            return 1;
        }
        
        //State
        int[] stairs = new int[n + 1];
        
        // initialize
        stairs[0] = 1;
        stairs[1] = 1;
        
        //state convert
        for (int cur = 2; cur < n+1; cur++) {
                stairs[cur] = stairs[cur - 1] + stairs[cur - 2];
        }
        
        return stairs[n];
    }
}