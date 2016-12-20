# problem     
Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero. To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
```
Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
```



# My solution

* save A+B to the map     
* find C+D which equal to -(A+B) to make A+B+C+D = 0



# Time complexity     
* O(n^2)
