package com.jshen;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution {
    public String reverseWords(String s){
        //1. remove all the space from left and right
        int left = 0;
        int right = s.length() - 1;

        while(left < right && s.charAt(left) == ' '){
            left++;
        }

        while(left < right && s.charAt(right) == ' '){
            right--;
        }

        //2.iterate, and capture words into stack
        Stack<String> d = new Stack<>();
        StringBuilder word = new StringBuilder();

        while(left <= right){
            char c = s.charAt(left);

            if(c != ' '){
                word.append(c);
            } else if(word.length() != 0 && c == ' '){
                d.push(word.toString());
                word.setLength(0);
            }
            left++;
        }
        d.push(word.toString());

        //3. output words from stack, and append to StringBuilder
        StringBuilder res = new StringBuilder();
        while(!d.isEmpty()){
            res.append(d.pop());
            res.append(" ");
        }
        res.setLength(res.length() - 1);
        return res.toString();
    }

//    public String reverseWords(String s) {
//        StringBuilder sb = new StringBuilder();
//        int end = 0;
//
//        for (int i = s.length() - 1; i >= 0; i--) {
//            if (s.charAt(i) == ' ') continue;
//            end = i;
//            i = s.lastIndexOf(' ', end);
//            sb.append(s.substring(i + 1, end + 1)).append(' ');
//        }
//
//        return sb.toString().trim();
//    }
}
