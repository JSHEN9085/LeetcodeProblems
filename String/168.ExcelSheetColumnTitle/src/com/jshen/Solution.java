package com.jshen;

import java.util.ArrayDeque;

public class Solution {

    //A: 65, Z: 90
    public String convertToTitle(int n) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        while(n > 0){
            n--;
            stack.push((char) (n % 26 + 65));
            n = n / 26;
        }

        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.toString();
    }
}
