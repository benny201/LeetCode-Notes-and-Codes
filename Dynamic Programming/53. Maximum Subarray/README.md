# Problem 
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
```
For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
```

# My solution

* state: result[i] represent that the maximun result in the subarray(nums[0] ~ nums[i]). 
* state transition: update every result[i] 
```
two situations : `result[i] = nums[i]` or `result[i] = nums[i] + result[i - 1]`
```

# Time complexity     
* O(n)

