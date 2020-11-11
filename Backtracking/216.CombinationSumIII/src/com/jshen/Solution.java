package com.jshen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    //input = {1, 2, 3, 4, 5, 6, 7, 8, 9}

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        if(k == 0 || n == 0) return res;

        List<Integer> combo = new ArrayList<>();
        helper(res, combo, k, n, 1);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> combo,
                        int k, int n, int start){

        if(combo.size() == k && n == 0){
            res.add(new ArrayList<Integer>(combo));
            return;
        }

        for(int i = start; i < 10; i++){
            if(i > n) break;
            combo.add(i);
            helper(res, combo, k, n - i, i + 1);
            combo.remove(combo.size() - 1);
        }
    }


}
