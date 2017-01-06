# Problem 
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

# My solution

* 研究最后一个字符的匹配关系.
* 分两种情况讨论 ： 1、S1 的第i位 等于 S2 的第j位 & 2、S1 的第i位 不等于 S2 的第j位     
* 若等于: 三种方案： 1) res[i - 1][j - 1] : 直接使用第i、j  & 2) res[i][j - 1] ＋ 1: 在末尾delete j,所以多一个操作 & 3) res[i - 1][j] + 1: 在末尾insert j，所以多出一个操作     
* 若不等于: 三种方案: 1) res[i - 1][j - 1] + 1: replace & 2) res[i][j - 1] + 1 : delete  & 3) res[i - 1][j] + 1 : insert

# My solution in Java
```java
public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        
        //state 
        int w1_len = word1.length();
        int w2_len = word2.length();
        int[][] res = new int[w1_len + 1][w2_len + 1];
        
        //initialize
        for (int i = 0; i < w1_len + 1; i++) {
            res[i][0] = i;
        }
        
        for (int i = 0; i < w2_len + 1; i++) {
            res[0][i] = i;
        }
        
        //state transition
        for (int i = 1; i < w1_len + 1; i++) {
            for (int j = 1; j < w2_len + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    res[i][j] = Math.min(res[i - 1][j - 1], res[i][j - 1] + 1);
                    res[i][j] = Math.min(res[i][j], res[i - 1][j] + 1);
                } else {
                    res[i][j] = Math.min(res[i - 1][j - 1] + 1, res[i][j - 1] + 1);
                    res[i][j] = Math.min(res[i][j], res[i - 1][j] + 1);
                }
            }
        }
        
        //result
        return res[w1_len][w2_len];
    }
}
```



# Time complexity     
* O(w1_len * w2_len)
