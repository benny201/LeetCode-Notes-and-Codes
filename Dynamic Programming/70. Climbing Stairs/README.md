# Problem 
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


# My solution

* state: stairs[cur] represents that the total ways to reach the `cur th` stair. 
* state transition: 
* two ways to arrive `cur th`stair: 1, take one step by another; 2, take two step at one time
```
stairs[cur] = stairs[cur - 1] + stairs[cur - 2]
```

# Time complexity     
* O(n)

