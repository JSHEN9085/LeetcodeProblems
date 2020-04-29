package com.jshen;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int size = digits.length;

        for(int i = size - 1; i >= 0; i--){ //modify the nums starting from the back
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }// for special case like [9,9,9,9,9,9], it will be 1000000 after plus one, and we expect [1, 0, 0, 0, 0, 0, 0]

        int[] newDigits = new int[size + 1]; //therefore we need another array that has length as size+1
        newDigits[0] = 1; //since array declared as value = 0 as default, so we just need to modify the first num as 1;
        return newDigits;
    }
}
