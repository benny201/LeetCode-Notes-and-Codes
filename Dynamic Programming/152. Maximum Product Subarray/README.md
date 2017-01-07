# Problem 
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

```java
For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
```


# My solution

* 因为数组元素有正负，所以要保留最小值以及最大值的结果
* 比较 Max[i - 1] * nums[i] ／ Min[i - 1] * nums[i] / nums[i] 三种情况的最大值去更新Max[i];
* 比较 Max[i - 1] * nums[i] ／ Min[i - 1] * nums[i] / nums[i] 三种情况的最小值去更新Min[i];

# My solution in Jave

```java
public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        //state 
        int[] MaxRes = new int[nums.length];
        int[] MinRes = new int[nums.length];
        
        //initialize
        MaxRes[0] = nums[0];
        MinRes[0] = nums[0];
        int res = nums[0];
        
        //state transition
        for (int i = 1; i < nums.length; i++) {
            MaxRes[i] = Math.max(nums[i], Math.max(MaxRes[i - 1] * nums[i], MinRes[i - 1] * nums[i]));
            MinRes[i] = Math.min(nums[i], Math.min(MinRes[i - 1] * nums[i], MaxRes[i - 1] * nums[i]));
            
            res = Math.max(res, MaxRes[i]);
        }
        
        return res;
    }
}
```

# Time complexity     
* O(n)
