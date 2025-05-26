package com.springboot.MySpringApp.basicBinarySearchApp;

import com.springboot.MySpringApp.MySpringAppApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import static org.springframework.boot.SpringApplication.run;


/**
 * One of the reason to use interfaces is to reduce coupling and increase flexibility
 * Multiple implementations of the same interface can be provided
 * Plug and Play Interfaces let you swap algorithms or behaviors easily.
 * Polymorphism is the ability to take many forms which is what interfaces provide
 */
@SpringBootApplication
public class Driver {
    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(Driver.class, args);

        BinarySeachImpl binarySeachImpl = applicationContext.getBean(BinarySeachImpl.class);

        int result = binarySeachImpl.binarySearch(new int[]{5,4,3,2,1}, 4);
        System.out.println("Element found at index "+result);


    }
}


// Web Services + Microservices -> Cloud Services -> Artificial Intelligence -> Robotics