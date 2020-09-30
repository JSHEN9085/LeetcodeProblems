package com.jshen;

public class Main {

    public static void main(String[] args) {
        String str = "8";
	    int num = '8' - '0' ;
        System.out.println(str);
        System.out.println(num);
        System.out.println(Integer.parseInt(str) + 10); // expect 18
    }
}
