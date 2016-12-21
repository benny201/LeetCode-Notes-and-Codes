README.md

# Problem 
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.


# My solution

* 二分法的变形：倍增法
* let divisor += divisor to approximate dividend more quickly(use less times of addition!!!!!!) 

# Difficulties
* convert the int input to a long input to avoid overfolw

# Time complexity     
* O(logn)
