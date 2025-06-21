package com.springcore.springcore.beanScope;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component("driverBeanScope")
@SpringBootApplication
public class Driver {

    private static Logger LOGGER = LoggerFactory.getLogger(Driver.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Driver.class, args);
        Person person1 = context.getBean(Person.class);
        Person person2 = context.getBean(Person.class);

        LOGGER.info("{}", person1);
        LOGGER.info("{}", person1.getMan());

        LOGGER.info("{}", person2);
        LOGGER.info("{}", person2.getMan());

        if(person1 == person2){
            System.out.println("Objects are Same");
        } else {
            System.out.println("Objects are not Same");
        }

        Man man1 = person1.getMan();
        Man man2 = person2.getMan();

        if(man1.toString() == man2.toString()){
            System.out.println("Objects are Same");
        } else {
            System.out.println("Objects are not Same");
        }


    }
}
