package com.leetcode.problems;

import java.util.Arrays;

//We are given two arrays that represent the arrival and departure times of trains, the task is to find the minimum number of platforms required so that no train waits.
       // Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}, dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00} //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TrainArrivalsAndDepartures {

//    public int findNunmberOfPlatforms(int[] arrivalTime, int[] departureTime) {
//        int platformsCount = 1;
//
//        // Efficiency is O(NlogN) due to sorting
//        Arrays.sort(arrivalTime);
//        Arrays.sort(departureTime);
//        int maxPlatforms = 0;
//        for(int i = 1, j = 0; i < arrivalTime.length && j < departureTime.length;) {
//            // If a train is arriving, increment platform count
//                if(arrivalTime[i] <= departureTime[j]) {
//                    platformsCount++;
//                    maxPlatforms = Math.max(maxPlatforms, platformsCount);
//                    i++;
//                } else {
//                    platformsCount--;
//                    j++;
//                }
//            }
//        return platformsCount;
//    }

    public int findNunmberOfPlatformsUsingWhile(int[] arrivalTime, int[] departureTime) {
        int platformsCount = 1;

        // Efficiency is O(NlogN) due to sorting
        Arrays.sort(arrivalTime);
        Arrays.sort(departureTime);
        int maxPlatforms = 0;
        int i = 1, j = 0;
        while( i < arrivalTime.length && j < departureTime.length) {
            // If a train is arriving, increment platform count
            if(arrivalTime[i] <= departureTime[j]) {
                platformsCount++;
                maxPlatforms = Math.max(maxPlatforms, platformsCount);
                i++;
            } else {
                platformsCount--;
                j++;
            }
        }
        return maxPlatforms;
    }
    public static void main(String[] args) {
        int[] arrivalTime = new int[] {900, 940, 950, 1100, 1500, 1800};
        int[] departureTime = new int[] {910, 1200, 1120, 1130, 1900, 2000};
        System.out.print( new TrainArrivalsAndDepartures().findNunmberOfPlatformsUsingWhile(arrivalTime, departureTime));
    }
}