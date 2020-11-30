package com.jshen;

public class Solution {
    //Transpose then reverse
    //Time: O(n^2) actual is O(2n^2)
    //Space: O(1)
//    public void rotate(int[][] matrix) {
//        int n = matrix.length;
//
//        for(int i = 0; i < n; i++){
//            for(int j = n; j < n; j++){
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[j][i];
//                matrix[j][i] = temp;
//            }
//        }
//
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n/2; j++){
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[i][n - 1 - j];
//                matrix[i][n - 1 - j] = temp;
//            }
//        }
//    }


    //rotate corner
    //Time:
    //Space: O(1)
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) { //(n + 1) /2 ensure it includes the mid point
            System.out.println("i is " + i);
            for (int j = 0; j < n / 2; j++) {
                System.out.println("j is " + j);
                int[] tmp = new int[4];
                int row = i;
                int col = j;
                for (int k = 0; k < 4; k++) { //this for loop is putting 4 corners into temp array
                    tmp[k] = matrix[row][col];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                } //after this for loop, row and col stopped at the original position

                for (int k = 0; k < 4; k++) {// iterate each corner again, but assign different num to each corner
                    matrix[row][col] = tmp[(k + 3) % 4];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                }
            }
        }
    }

}
