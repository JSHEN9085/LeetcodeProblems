package com.jshen;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] input = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        System.out.println(input.length);
        solution.reverseWords(input);
        System.out.println(input);
        System.out.println(input.length);
    }
}
