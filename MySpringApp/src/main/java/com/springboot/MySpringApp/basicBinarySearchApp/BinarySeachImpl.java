package com.springboot.MySpringApp.basicBinarySearchApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySeachImpl {

    //Create a bean and autowire the bean in the dependency

    // @Autowired tells Spring to wire the dependency of this class in SortAlgo
    @Autowired
    private ISortAlgo bubbleSortImpl;

    /**
     * Constructor Injection
     *
     */
    public BinarySeachImpl(ISortAlgo bubbleSortImpl) {
        super();
        bubbleSortImpl = bubbleSortImpl;
    }

    /**
     * Setting Injection
     * @param arr
     * @param target
     * @return
     */
//    public void setArraySort(ISortAlgo arraySort) {
//        this.arraySort = arraySort;
//    }

    public int binarySearch(int[] arr, int target) {

        bubbleSortImpl.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


}
