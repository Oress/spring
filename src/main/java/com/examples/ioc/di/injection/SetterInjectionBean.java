package com.examples.ioc.di.injection;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetterInjectionBean {
    private Dependency1 dep1;
    private Dependency3 dep3;

    @Autowired
    public void setDep1(Dependency1 dep1) {
        this.dep1 = dep1;
    }

    public void setDep3(Dependency3 dep3) {
        this.dep3 = dep3;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("ConstructorInjBean.postConstruct");
    }
}
