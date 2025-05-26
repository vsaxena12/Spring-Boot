package com.springboot.MySpringApp.basicBinarySearchApp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class QuickSortImpl implements ISortAlgo{

    @Override
    public int[] sort(int[] arr) {
        System.out.println("Quick Sort");
        Arrays.sort(arr);
        return arr;
    }
}
