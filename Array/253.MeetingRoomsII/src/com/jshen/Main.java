package com.jshen;

public class Main {

    public static void main(String[] args) {
	    int[][] input1 = {{0,30}, {5,10}, {15,20}};
        int[][] input2 = {{7,10}, {2,4}};
	    MeetingRooms test = new MeetingRooms();
        System.out.println(test.minMeetingRooms(input1));
    }
}
