# Problem 
n the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.

For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.

Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.

``` java
Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
Output: 4

Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
```     

# My solution

* 双序列型
* res[i][j] : 代表i个0 以及 j个1 的情况下的最大值
* 状态转移: res[i][j] = Math.max(res[i][j], 1 + res[i - (0s of str)][j - (1s of str)])
* res[i - (0s of str)][j - (1s of str)] 表示 在包括该string的情况下得到的最优解


# My solution in Java
```java
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        
        //state
        int[][] res = new int[m + 1][n + 1];
        int[][] ZOs = new int[strs.length][2];
        
        //intialize
        //count zeros and ones
        for (int i = 0; i < strs.length; i++) {
            //int m = 0, n = 0;
            ZOs[i] = countZO(strs[i]);
            
        }
        
        //state transition
        for(int i = 0; i < strs.length; i++) {
            for (int curtM = m; curtM >= ZOs[i][0]; curtM--) {
                for (int curtN = n; curtN >= ZOs[i][1]; curtN--) {
                    res[curtM][curtN] = Math.max(res[curtM][curtN], 1 + res[curtM - ZOs[i][0]][curtN - ZOs[i][1]]);
                }
            }
        }
        
        //result
        return res[m][n];
        
    }
    
    //count zeros and ones
    public int[] countZO(String str) {
        int[] res = new int[2];
        if (str == null || str.length() ==0) {
            res[0] = 0;
            res[1] = 0;
            return res;
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    res[0]++;
                } else if(str.charAt(i) == '1'){
                    res[1]++;
                }
            }
            return res;
        }
    }
    
    
}
```



# Time complexity     
* O(s1_len * s2_len)