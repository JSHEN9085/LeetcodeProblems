package com.jshen;

import java.util.Arrays;

//Given a n x n matrix, row and col has the same length n
public class Solution {

    //brute force, Time: O(N^2 + N^2logN^2), space: O(n^2)
//    public int kthSmallest(int[][] matrix, int k) {
//        int n = matrix.length;
//        int m = matrix[0].length;
//
//        int[] arr = new int[n * m];
//        int pointer = 0;
//
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < m; j++){
//                arr[pointer] = matrix[i][j];
//                pointer++;
//            }
//        }
//
//        Arrays.sort(arr);
//        return arr[k - 1];
//    }

    //binary search
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];

        while(left < right){
            int mid = (right - left) / 2 + left;
            if(check(matrix, mid, k, n)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[][] matrix, int mid, int k, int n){
        int i = n - 1;
        int j = 0;
        int num = 0;

        while(i >= 0 && j < n){
            if(matrix[i][j] <= mid){
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }
}
