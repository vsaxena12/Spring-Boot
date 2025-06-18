package com.springcore.springcore.usingInterfacesDI;

import java.util.Arrays;

public class QuickSort implements Sort{
    public int[] sort(int[] numbers){
        Arrays.sort(numbers);
        return numbers;
    }
}