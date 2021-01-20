package com.jshen;

public class Solution {
    public int numIslands(char[][] grid){
        if(grid.length == 0 || grid[0].length == 0 || grid == null) return 0;

        int count = 0;
        int row = grid.length;
        int col = grid[0].length;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, row, col);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, int row, int col){
        if(i >= row || j >= col || i < 0 || j < 0 || grid[i][j] == '0') return;
        if(grid[i][j] == '1') grid[i][j] = '0';
        dfs(grid, i - 1, j, row, col);
        dfs(grid, i + 1, j, row, col);
        dfs(grid, i, j - 1, row, col);
        dfs(grid, i, j + 1, row, col);
    }
}
