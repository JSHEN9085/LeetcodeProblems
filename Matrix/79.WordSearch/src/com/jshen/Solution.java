package com.jshen;

public class Solution {
    public boolean exist(char[][] board, String word){
        int row = board.length;
        int col = board[0].length;

        char[] w = word.toCharArray();

        for(int y = 0; y < row; y++){
            for(int x = 0; x < col; x++){
                if(helper(board, w, x, y, row, col, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, char[] w,
                           int x, int y, int row, int col,
                           int i){
        if(i >= w.length) return true;

        if(x < 0 || y < 0 || y >= row || x >= col) return false;

        if(board[y][x] == w[i]){
            char c = board[y][x];
            board[y][x] = '#';
            boolean res = helper(board, w, x - 1, y, row, col, i + 1) ||
                    helper(board, w, x + 1, y, row, col, i + 1) ||
                    helper(board, w, x, y + 1, row, col, i + 1) ||
                    helper(board, w, x, y - 1, row, col, i + 1);
            board[y][x] = c;
            return res;
        }
        return false;
    }
}
