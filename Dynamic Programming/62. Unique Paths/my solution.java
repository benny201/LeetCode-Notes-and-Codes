public class Solution {
    public int uniquePaths(int m, int n) {
        /*int[][] path = new int[m][n];
        
        for(int i=0;i<m;i++) {
            path[i][0] = 1;
        }
        for(int i=0;i<n;i++) {
            path[0][i] = 1;
        }
        
        
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                path[i][j] = path[i-1][j] + path[i][j-1];
            }
        }
        return path[m-1][n-1];*/
        
        if ( m == 0 && n == 0) {
            return 1;
        }
        
        //state
        int[][] path = new int[m][n];
        
        //initialize
        for (int i = 0; i < m; i++) {
            path[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            path[0][i] = 1;
        }
        
        //state transition
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                path[row][col] = path[row - 1][col] + path[row][col - 1];
            }
        }
        return path[m - 1][n - 1];
    }
}