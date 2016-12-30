# Problem 
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.


# My solution

* state: path[row][col] represents that the total ways to reach the grid[row][col]. 
* state transition: 
* two ways to arrive a grid: 1, from the top grid; 2, from the left grid (Because there are only two wats to move: down or right)
```
path[row][col] = Math.min(path[row - 1][col] , path[row][col - 1]) + grid[row][col];
```
* initialize: there is only one way to reach the toppest row element(from left one) and the rightmost element(from the above one)

# Time complexity     
* O(n^2)

