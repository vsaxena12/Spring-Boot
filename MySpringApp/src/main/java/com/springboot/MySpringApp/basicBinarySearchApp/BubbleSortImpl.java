package com.springboot.MySpringApp.basicBinarySearchApp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @Component tells Spring to create a bean of this class
 */
@Component
public class BubbleSortImpl implements ISortAlgo {

    @Override
    public int[] sort(int[] arr) {
        System.out.println("Bubble Sort");
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
