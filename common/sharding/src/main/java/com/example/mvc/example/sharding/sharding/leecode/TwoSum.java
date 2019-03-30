package com.example.mvc.example.sharding.sharding.leecode;

import java.util.Arrays;

public class TwoSum {


    public static void main(String[] args) {


        int[] ints = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(resolver(ints, 9)));


    }

    public static int[] resolver(int[] ints, int sum){

        int a = 0;
        int b = ints.length - 1;
        while (a < b){
            int aValue = ints[a];
            int bValue = ints[b];
            if(aValue + bValue == sum) return new int[]{a + 1, b + 1};
            if(aValue + bValue > sum) {b--;continue;}
            if(aValue + bValue < sum) {a++;continue;}
            return new int[]{-1, -1};
        }

        return new int[]{};

    }


}
