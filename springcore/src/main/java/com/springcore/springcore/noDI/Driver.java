package com.springcore.springcore.noDI;

/**
 * Here if I want to implement Quick sort then it is difficult since it is tightly coupled.
 */
public class Driver {
    public static void main(String[] args) {
        BinarySearchImpl binarySearch = new BinarySearchImpl();
        int result = binarySearch.binarySearch(new int[]{5,2,3,1,4}, 6);
        System.out.println("Result: "+result);
    }
}
