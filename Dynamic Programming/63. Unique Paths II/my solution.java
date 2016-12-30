public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 1;
        }
        
        //state
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] path = new int[row][col];
        
        //initialize
        path[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < row; i++) {
            path[i][0] = (path[i - 1][0] != 0 && obstacleGrid[i][0] != 1) ? 1 : 0;
        }
        for (int i = 1; i < col; i++) {
            path[0][i] = (path[0][i - 1] != 0 && obstacleGrid[0][i] != 1) ? 1 : 0;
        }
        
        //state transition
        for (int R = 1; R < row; R++) {
            for (int C = 1; C < col; C++) {
                if (obstacleGrid[R][C] == 1) {
                    path[R][C] = 0;
                } else {
                    path[R][C] =  path[R - 1][C] + path[R][C - 1];
                }
            }
        }
        
        return path[row - 1][col - 1];
    }
}