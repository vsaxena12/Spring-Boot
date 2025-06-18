package com.springcore.springcore.springDI;

import java.util.Arrays;

public class QuickSort implements Sort {
    public int[] sort(int[] numbers){
        Arrays.sort(numbers);
        return numbers;
    }
}