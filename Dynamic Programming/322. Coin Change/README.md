# Problem 
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)
```     

# My solution

* 单序列型
* two situation: 
* 1.res[j] represents minimun number of coins without coins[i]
* 2.res[j - coins[i]] represents minimun number of coins when uses coins[i]
* intialize: res[0] = 1 & res[others] = amount + 1;


# My solution in Java
```java
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        
        //state
        int[] res = new int[amount + 1];
        
        //initializ
        res[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            res[i] = amount + 1;
        }
        
        
        
        //state transition
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j >= coins[i]) {
                    res[j] = Math.min(res[j], 1 + res[j - coins[i]]);
                }
            }
        }
        
        return res[amount] > amount ? -1 : res[amount];
    }
}
```



# Time complexity     
* O(n ^ 2)