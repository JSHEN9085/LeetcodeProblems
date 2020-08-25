package com.jshen;

public class Main {

    public static void main(String[] args) {
//        System.out.println(4 % 7); // 4 / 7 = 0 and remain 4

        int count = 0;
//        while(count < 3){
//            System.out.println(count);
//            count++;
//        }

        //do while will ensure at least execute once and then check the condition
        do{
            System.out.println(count);
            count++;
        } while(count != 6);
    }
}
