package com.jshen;



public class UniqueBST {
//requirement of question: 1 <= n <= 19

    public int numTrees(int n) {
        if(n == 0 || n == 1) return 1;

        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                nums[i] += nums[j] * nums[i - 1 - j];
            }
        }
        return nums[n];
    }

//nums[1, 1, 2, 5 ...]
}
