package com.jshen;

public class Solution {
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0 || board == null) return;

        int row = board.length;
        int col = board[0].length;

        //travel vertical board first
        for(int i = 0; i < row; i++){
            if(board[i][0] == 'O'){
                dfs(board, i, 0, row, col);
            }
            if(board[i][col - 1] == 'O'){
                dfs(board, i, col - 1, row, col);
            }
        }

        //travel horizontal board
        for(int j = 0; j < col; j++){
            if(board[0][j] == 'O'){
                dfs(board, 0, j, row, col);
            }
            if(board[row - 1][j] == 'O'){
                dfs(board, row - 1, j, row, col);
            }
        }

        //flipping
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'A') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j, int row, int col){
        if(i < 0 || i >= row || j < 0 || j >= col || board[i][j] != 'O'){
            return;
        }

        if(board[i][j] == 'O'){
            board[i][j] = 'A';
        }

        dfs(board, i - 1, j, row, col);
        dfs(board, i + 1, j, row, col);
        dfs(board, i, j - 1, row, col);
        dfs(board, i, j + 1, row, col);
    }
}
