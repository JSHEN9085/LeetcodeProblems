package com.jshen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> addToArrayForm(int[] num, int k){

        LinkedList<Integer> res = new LinkedList<>();
        int carry = 0;

        for(int i = num.length - 1; i >= 0 || k > 0 || carry == 1; i--, k /= 10){
            if(i >= 0){
                res.addFirst( (num[i] + (k % 10) + carry) % 10 );
                carry = (num[i] + (k % 10) + carry) / 10;
            } else {
                res.add( ((k % 10) + carry) % 10 );
                carry = ((k % 10) + carry) / 10;
            }
        }
        return res;
    }
}
