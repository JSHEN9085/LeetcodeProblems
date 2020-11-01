package com.jshen;

import java.util.LinkedList;
import java.util.List;

public class LetterToNumber {
    private static final String[] keys = new String[] {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if(digits.length() == 0 || digits == null) return res;

        backtracking(digits, res, new StringBuilder(), 0);
        return res;
    }

    private void backtracking(String digits, List<String> res, StringBuilder sb, int start){
        int size = sb.length();
        if(size == digits.length()){
            res.add(sb.toString());
            return;
        }

        String letters = keys[digits.charAt(start) - '0'];
        for(char c : letters.toCharArray()){
            sb.append(c);
            backtracking(digits, res, sb, start + 1);
            sb.setLength(size);
        }
    }
}
