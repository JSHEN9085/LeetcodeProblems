package com.jshen;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost){
        if(gas == null || gas.length == 0 || cost == null || cost.length == 0){
            return -1;
        }

        int start = 0;
        int total = 0; //total gas - total cost, if sum of all gas is < sum of all cost, we are impossible to complete the circuit
        int remain = 0; //starting from start, gas - cost

        for(int i = 0; i < gas.length; i++){
            total += gas[i] - cost[i];
            if(remain >= 0){
                remain += gas[i] - cost[i];
            } else {
                remain = gas[i] - cost[i];
                start = i;
            }
        }

        if(total < 0) return -1;

        return start;
    }



    //brute force
//    public int canCompleteCircuit(int[] gas, int[] cost){
//        if(gas == null || gas.length == 0 || cost == null || cost.length == 0){
//            return -1;
//        }
//
//        int start = -1;
//
//        for(int i = 0; i < gas.length; i++){ //for every point in gas station, we start a cycle to see if we can complete
//            int total = 0;
//            for(int j = 0; j < cost.length; j++){
//                total += gas[ (i + j) % gas.length ] - cost[ (i + j) % gas.length];
//                if(total < 0){
//                    break; //not enough fuel, break the loop
//                }
//                if(j == cost.length - 1){ //key step: if j reach (cost.length - 1), it means we have completed one cycle and i is the answer
//                    start = i; //assign i to start and break the loop
//                    break;
//                }
//            }
//        }
//        return start;
//    }
}
