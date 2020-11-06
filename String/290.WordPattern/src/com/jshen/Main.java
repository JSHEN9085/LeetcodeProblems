package com.jshen;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String patter = "a";
        String s = "a";
        List<String> words = solution.stringToWords(s);
        System.out.println(words.size());
//        System.out.println(solution.wordPattern(patter, s));

    }
}
