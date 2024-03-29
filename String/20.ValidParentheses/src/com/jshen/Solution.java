package com.jshen;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            } else if( c == '['){
                stack.push(']');
            } else if(c == '{'){
                stack.push('}');
            } else {
                if(stack.isEmpty() || c != stack.pop() ){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
