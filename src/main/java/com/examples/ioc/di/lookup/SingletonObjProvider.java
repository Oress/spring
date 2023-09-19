package com.examples.ioc.di.lookup;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
public class SingletonObjProvider {
    // ObjectFactory and ObjectProvider are pretty much the same, but ObjectProvider has more features
    ObjectFactory<PrototypeBean> prototypeFactory;
    ObjectProvider<PrototypeBean> prototypeProvider;

    public SingletonObjProvider(ObjectFactory<PrototypeBean> prototypeFactory, ObjectProvider<PrototypeBean> prototypeProvider) {
        this.prototypeFactory = prototypeFactory;
        this.prototypeProvider = prototypeProvider;
    }

    @PostConstruct
    public void postConstruct() {
        PrototypeBean p1 = prototypeFactory.getObject();
        PrototypeBean p2 = prototypeFactory.getObject();
        System.out.println("SingletonObjProvider p1 == p2: " + (p1 == p2));
    }
}
