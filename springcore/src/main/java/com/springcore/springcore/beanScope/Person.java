package com.springcore.springcore.beanScope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Person {

    @Autowired
    private Man man;

    public Person(Man man) {
        System.out.println("Person");
        this.man = man;
    }

    public Man getMan() {
        return man;
    }

    public void setMan(Man man) {
        this.man = man;
    }
}
