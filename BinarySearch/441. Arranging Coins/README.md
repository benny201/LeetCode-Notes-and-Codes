# Problem 

You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.     

```
n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
```



# My solution

* according Summation of Equal Difference Series Formula : n = ((1 + numbers) * numbers) / 2     
* convert the problem to find the last position of n satisfy inputNumber >=  ((1 + n) * n) / 2
* solve it by BinarySearch     



# Time complexity     
* O(logn)


# Difficulties
* convert the int input to a long input to avoid overfolw
