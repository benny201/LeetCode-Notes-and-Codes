public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        int sizeofres = 0;
        for(int num : nums) {
            int low = 0;
            int high = sizeofres;
            while(low<high) {
                int mid = low + (high-low)/2;
                if(res[mid]<num) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            res[low] = num;
            if(low == sizeofres) {
                sizeofres++;
            }
        }
        return sizeofres;
    }
}