# Problem 

Given two strings, find the longest common subsequence (LCS).

Your code should return the length of LCS.
   

# My solution

* state: res[i][j] : the LCS of two String(A.substring(0,i + 1) , B.substring(0,j + 1));
* There are three situation to find the LCS : 
* 1 : res[i - 1][j - 1] + 1 (include i,j);
* 2 : res[i - 1][j] (exclude i);
* 3 : res[i][j - 1] (exclude j);
* update the state array by the situations above;
       
# My solution in java:
```
public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        if (A == null || A.length() == 0) {
            return 0;
        }
        
        if (B == null || B.length() == 0) {
            return 0;
        }
        
        //state 
        int[][] res = new int[A.length() + 1][B.length() + 1];
        
        //state transition
        
        for (int indexA = 1; indexA < A.length() + 1; indexA++) {
            for (int indexB = 1; indexB < B.length() + 1; indexB++) {
                if (A.charAt(indexA - 1) == B.charAt(indexB - 1)) {
                    res[indexA][indexB] = Math.max(res[indexA - 1][indexB], res[indexA][indexB - 1]);
                    res[indexA][indexB] = Math.max(res[indexA][indexB], res[indexA - 1][indexB - 1] + 1); 
                } else {
                    res[indexA][indexB] = Math.max(res[indexA - 1][indexB], res[indexA][indexB - 1]);
                    res[indexA][indexB] = Math.max(res[indexA][indexB], res[indexA - 1][indexB - 1]);
                }
            }
        }
        
        //result 
        
        return res[A.length()][B.length()];
        
        
    }
}
```

# Time complexity     
* O(n^2)


