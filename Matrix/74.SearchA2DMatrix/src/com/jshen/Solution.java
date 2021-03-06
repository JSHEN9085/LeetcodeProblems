package com.jshen;

public class Solution {

    //O(n + m), worst case is target sit at matrix[matrix.length - 1][0]
    //so the method will screen each row and then each col
//    public boolean searchMatrix(int[][] matrix, int target) {
//        if(matrix.length == 0 || matrix[0].length == 0 || matrix == null) return false;
//        int row = 0;
//        int col = matrix[0].length - 1;
//
//        while(row < matrix.length && col >= 0){
//            if(matrix[row][col] == target){
//                return true;
//            } else if(matrix[row][col] < target){
//                row++;
//            } else{
//                col--;
//            }
//        }
//        return false;
//    }

    //O(log(mn))
    public boolean searchMatrix(int[][] matrix, int target){
        if(matrix.length == 0 || matrix[0].length == 0 || matrix == null) return false;

        int n = matrix.length, m = matrix[0].length;
        int start = 0, end = m * n - 1;

        while(start <= end) {
            int mid = (end - start) / 2 + start;
            int midValue = matrix[mid / m][mid % m];

            if(midValue == target){
                return true;
            } else if(midValue < target){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
