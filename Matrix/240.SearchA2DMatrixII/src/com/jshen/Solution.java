package com.jshen;

public class Solution {
    //O(n + m)
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0 || matrix == null) return false;
        
        int row = matrix.length - 1;
        int col = 0;
        int colEnd = matrix[0].length;

        while(row >= 0 && col < colEnd){
            if(matrix[row][col] > target){
                row--;
            } else if(matrix[row][col] < target){
                col++;
            } else {
                return true;
            }
        }
        return false;
    }
}
