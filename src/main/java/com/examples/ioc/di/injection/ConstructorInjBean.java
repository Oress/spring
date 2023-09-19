package com.examples.ioc.di.injection;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class ConstructorInjBean {
    private final Dependency1 dep1;
    private final Dependency3 dep3;

    public ConstructorInjBean(Dependency1 dep1, Dependency3 dep3) {
        this.dep1 = dep1;
        this.dep3 = dep3;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("ConstructorInjBean.postConstruct");
        assert dep1 != null;
        assert dep3 != null;
    }
}
