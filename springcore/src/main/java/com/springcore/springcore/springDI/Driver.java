package com.springcore.springcore.springDI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class Driver {
    public static void main(String[] args) {
        //BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSort());
        ApplicationContext context = SpringApplication.run(Driver.class, args);
        BinarySearchImpl binarySearch = context.getBean(BinarySearchImpl.class);
        int result = binarySearch.binarySearch(new int[]{5,2,3,1,4}, 6);
        System.out.println("-----------------------------------------------");
        System.out.println("Result: "+result);
        System.out.println("-----------------------------------------------");

    }
}
