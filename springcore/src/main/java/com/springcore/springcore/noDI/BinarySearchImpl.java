package com.springcore.springcore.noDI;

public class BinarySearchImpl {
    public int binarySearch(int[] numbers, int target) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] sortedNum = bubbleSort.sort(numbers);

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