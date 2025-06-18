package com.springcore.springcore.springDI;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BubbleSort implements Sort {
    public int[] sort(int[] numbers){
        Arrays.sort(numbers);
        return numbers;
    }
}
