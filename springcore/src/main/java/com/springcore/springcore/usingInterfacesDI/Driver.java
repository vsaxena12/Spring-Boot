package com.springcore.springcore.usingInterfacesDI;

/**
 * This method using interfaces and constructor makes the application a little more loosely coupled.
 * Here, manual DI is achieved via constructors and interfaces
 * Object lifecycle is managed manually
 */
public class Driver {
    public static void main(String[] args) {
        BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSort());
        int result = binarySearch.binarySearch(new int[]{5,2,3,1,4}, 6);
        System.out.println("Result: "+result);
    }
}
