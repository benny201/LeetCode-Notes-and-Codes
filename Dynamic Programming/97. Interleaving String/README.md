# Problem 
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

``` java
For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
```     

# My solution

* 研究最后一个字符的匹配关系. 跟 leetcode 72 类似.
* 分两种情况讨论 ：   
* 1、S1 的第i位 等于 S3 的第i + j位 : 如果res[i - 1][j] = true 即去掉第i位也匹配，说明res[i][j]也匹配     
* 2、S2 的第i位 不等于 S3 的第i + j位 :  如果res[i][j - 1] = true 即去掉第i位也匹配，说明res[i][j]也匹配

# My solution in Java
```java
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        //state 
        int s1_len = s1.length();
        int s2_len = s2.length();
        boolean[][] res = new boolean[s1_len + 1][s2_len + 1];
        
        //initialize
        res[0][0] = true;
        for (int i = 1; i < s1_len + 1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1) && res[i - 1][0] == true) {
                res[i][0] = true;
            }
        }
        for (int i = 1; i < s2_len + 1; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1) && res[0][i - 1] == true) {
                res[0][i] = true;
            }
        }
        
        //state transition
        for (int i = 1; i < s1_len + 1; i++) {
            for (int j = 1; j < s2_len + 1; j++) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && res[i - 1][j] == true) {
                    res[i][j] = true;
                } else if (s2.charAt(j - 1) == s3.charAt(i + j - 1) && res[i][j - 1] == true) {
                    res[i][j] = true;
                }
            }
        }
        
        //result 
        return res[s1_len][s2_len];
    }
}
```



# Time complexity     
* O(s1_len * s2_len)