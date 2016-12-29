public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // state & intialize
        int[] f = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
        }
        
        //result
        int maxResult = 0;
        
        // State convert
        for (int cur = 0; cur < f.length; cur++) {
            for (int prev = 0; prev < cur; prev++) {
                if (nums[prev] < nums[cur]) {
                    f[cur] = Math.max(f[cur], f[prev]+1);
                }
            }
            
            if (f[cur] >= maxResult) {
                maxResult = f[cur];
            }
        }
        
        return maxResult;
        
    }
}