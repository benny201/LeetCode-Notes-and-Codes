public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 1;
        }
        
        //state 
        int[][] path = new int[grid.length][grid[0].length];
        
        //initialize
        path[0][0] = grid[0][0];
        
        for (int i = 1; i < grid.length; i++) {
            path[i][0] = path[i - 1][0] + grid[i][0];
        } 
        
        for (int i = 1; i < grid[0].length; i++) {
            path[0][i] = path[0][i - 1] + grid[0][i];
        }
        
        //state transition
        for (int row = 1; row < grid.length; row++) {
            for (int col = 1; col < grid[0].length; col++) {
                path[row][col] = Math.min(path[row - 1][col] , path[row][col - 1]) + grid[row][col];
            }
        }
        
        return path[grid.length - 1][grid[0].length - 1];
    }
}