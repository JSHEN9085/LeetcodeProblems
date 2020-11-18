package com.jshen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0 || matrix == null) return res;

        int n = matrix.length;
        int m = matrix[0].length;

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while(res.size() < matrix.length * matrix[0].length){
            // Traverse Right
            for(int i = colBegin; i <= colEnd && res.size() < n * m; i++){
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            // Traverse down
            for(int i = rowBegin; i <= rowEnd && res.size() < n * m; i++){
                res.add(matrix[i][colEnd]);
            }
            colEnd--;

            // Traverse Left
            for(int i = colEnd; i >= colBegin && res.size() < n * m; i--){
                res.add(matrix[rowEnd][i]);
            }
            rowEnd--;

            // Traverse up
            for(int i = rowEnd; i >= rowBegin && res.size() < n * m; i--){
                res.add(matrix[i][colBegin]);
            }
            colBegin++;
        }
        return res;
    }
}
