package com.jshen;
//Input: grid = [
//        ["1","1","1","1","0"],
//        ["1","1","0","1","0"],
//        ["1","1","0","0","0"],
//        ["0","0","0","0","0"]
//        ]
//        Output: 1
// All '1' are neighbor, so the whole land is counted as 1 island

//Input: grid = [
//        ["1","1","0","0","0"],
//        ["1","1","0","0","0"],
//        ["0","0","1","0","0"],
//        ["0","0","0","1","1"]
//        ]
//        Output: 3
// same rule, top-left conner, the middle, and the bottom-right conner

public class NumberOfIslands {
    //DFS O(MN) row * column, space complexity
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int count = 0;
        final int rows = grid.length;
        final int column = grid[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < column; j++){
                if(grid[i][j] == '1'){
                    count++; //if we find '1', this means we found an island, and the next thing is flip all other '1' that is connected to this original '1'
                    dfs(grid, i, j, rows, column); //as we found the first '1', we already plus one into count, so the next thing is flip all other '1' that is connected to this original '1' to '0'
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, int rows, int column){
        //base case
        if(i < 0 || i >= rows || j < 0 || j >= column || grid[i][j] == '0'){
            return;
        } //if the parameter is over the limit, or the grid is water ('0') or already visited (flipped to '0'), return

        //recursion (the current position is a land '1')
        grid[i][j] = '0'; // flip it to '0' to mark it as visited, but then we need to travel all other position that connected to grid[i][j]
        dfs(grid, i - 1, j, rows, column); //at top
        dfs(grid, i + 1, j, rows, column); //at bottom
        dfs(grid, i, j - 1, rows, column); //at left
        dfs(grid, i, j + 1, rows, column); //at right
        //above 4 recursions is to flip 'land' at all 4 directions to '0', to avoid duplicated count
    }
}
