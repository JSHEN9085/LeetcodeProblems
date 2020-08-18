package com.jshen;

public class SurroundedRegions {
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        int row = board.length;
        int column = board[0].length;

        for(int i = 0; i < row; i++){
            if(board[i][0] == 'O'){
                dfs(i, 0, row, column, board);
            }
            if(board[i][column - 1] == 'O'){
                dfs(i, column - 1, row, column, board);
            }
        }

        for(int j = 0; j < column; j++){
            if(board[0][j] == 'O'){
                dfs(0, j, row, column, board);
            }
            if(board[row - 1][j] == 'O'){
                dfs(row - 1, j, row, column, board);
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'A') board[i][j] = 'O';
            }
        }
    }

    private void dfs(int i, int j, int row, int column, char[][]board){
        if(i < 0 || i > row - 1 || j < 0 || j > column - 1 || board[i][j] != 'O' ){
            return;
        }
        board[i][j] = 'A';
        dfs(i-1, j, row, column, board);
        dfs(i+1, j, row, column, board);
        dfs(i, j-1, row, column, board);
        dfs(i, j+1, row, column, board);
    }
}
