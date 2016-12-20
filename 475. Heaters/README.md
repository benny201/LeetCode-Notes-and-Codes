# problem 

Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.
So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.

```
Input: [1,2,3],[2]
Output: 1
Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
```



# My solution

* find the maximun radiu
* BinarySearch     
* convert the problem to find the first radiu which  the requirment in the range of (0,maximun);



# Time complexity     
* O(mlogn)  m-length of houses; n-length of heaters
