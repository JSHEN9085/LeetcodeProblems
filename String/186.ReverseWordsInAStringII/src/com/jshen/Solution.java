package com.jshen;



//Given an input string , reverse the string word by word.
//
//Example:
//
//Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
//Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
//Note:
//
//A word is defined as a sequence of non-space characters.
//The input string does not contain leading or trailing spaces.
//The words are always separated by a single space.
//Follow up: Could you do it in-place without allocating extra space?

public class Solution {
    public void reverseWords(char[] s){
        if(s.length == 0 || s == null) return;
        int start = 0, end = s.length - 1;
        reverse(s, start, end);

        int p = 0;
        while(start < end){
            if(s[start] != ' '){
                p = start;
                while(p <= end && s[p] != ' '){
                    p++;
                }
                reverse(s, start, p - 1);
                start = p;
            }
            start++;
        }
    }

    private void reverse(char[] s, int start, int end){
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }
    }
}
