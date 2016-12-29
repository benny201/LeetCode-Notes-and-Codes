# Problem 
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.     

# My solution

* Dynamic Programming
* F[i] 代表以`nums[i]`为终点所得到最长的subsequence.
* 从 0 到 i 更新 F[i].
* 更新条件1 : nums[prevIndex] < nums[curIndex] 即符合递增的属性   
* 更新条件2 : prevIndex < curIndex 即必须是i以前的数
* 更新条件3 : if F[curIndex] < F[prevIndex] + 1 => F[curIndex] = F[prevIndex] + 1;

# Time complexity     
* O(n^2)

# A better solution
* Binarysearch
* time complexity: O(nlogn)
