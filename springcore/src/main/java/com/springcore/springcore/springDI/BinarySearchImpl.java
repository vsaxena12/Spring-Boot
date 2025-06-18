package com.springcore.springcore.springDI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

    @Autowired
    private final Sort sort;

    public BinarySearchImpl(Sort sort) {
        this.sort = sort;
    }

    public int binarySearch(int[] numbers, int target) {
        int[] sortedNum = sort.sort(numbers);

        //Search the array
        int left = 0;
        int right = sortedNum.length-1;

        while(left<=right) {
            int mid = left+(right-left)/2;
            if(sortedNum[mid] == target){
                return sortedNum[mid];
            } else if(sortedNum[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }
}