package com.springcore.springcore.usingInterfacesDI;

import java.util.Arrays;

public class BubbleSort implements Sort{
    public int[] sort(int[] numbers){
        Arrays.sort(numbers);
        return numbers;
    }
}
