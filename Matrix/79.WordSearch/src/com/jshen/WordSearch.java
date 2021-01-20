package com.jshen;

public class WordSearch {
    public boolean exist(char[][] board, String word){
        char[] w = word.toCharArray();
        int row = board.length;
        int col = board[0].length;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(helper(board, w, row, col, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, char[] w,
                        int row, int col, int i, int j, int position){

        if(position >= w.length) return true;

        if(i < 0 || i >= row || j < 0 || j >= col) return false;

        if(board[i][j] == w[position]){
            char temp = board[i][j];
            board[i][j] = '#';
            boolean res = helper(board, w, row, col, i - 1, j, position + 1) ||
            helper(board, w, row, col, i + 1, j, position + 1) ||
            helper(board, w, row, col, i, j - 1, position + 1) ||
            helper(board, w, row, col, i, j + 1, position + 1);
            board[i][j] = temp;
            return res;
        }
        return false;
    }
}
