public class Solution {
    public int maxSubArray(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        //state
        int[] result = new int[nums.length];
        
        //initialize
        result[0] = nums[0];
        
        //result
        int res = nums[0];
        
        //state transition
        for (int i = 1; i < nums.length; i++) {
            result[i] = Math.max(nums[i], result[i - 1] + nums[i]);
            res = Math.max(res , result[i]);
        }
        
        return res;
        
    }
}