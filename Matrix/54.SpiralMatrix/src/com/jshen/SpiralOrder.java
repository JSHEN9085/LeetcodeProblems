package com.jshen;

import java.util.LinkedList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> res = new LinkedList<>();
        if(matrix.length == 0 || matrix[0].length == 0 || matrix == null) return res;

        int rowBeg = 0;
        int colBeg = 0;
        int rowEnd = matrix.length - 1;
        int colEnd = matrix[0].length - 1;

        while(rowBeg <= rowEnd && colBeg <= colEnd){
            //Travel to right
            for(int i = colBeg; i <= colEnd; i++){
                res.add(matrix[rowBeg][i]);
            }
            rowBeg++;

            //Travel to bottom
            for(int i = rowBeg; i <= rowEnd; i++){
                res.add(matrix[i][colEnd]);
            }
            colEnd--;

            //Travel to left
            if(rowBeg <= rowEnd){
                for(int i = colEnd; i >= colBeg; i--){
                    res.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }

            //Travel to top
            if(colBeg <= colEnd){
                for(int i = rowEnd; i >= rowBeg; i--){
                    res.add(matrix[i][colBeg]);
                }
                colBeg++;
            }
        }
        return res;
    }
}

