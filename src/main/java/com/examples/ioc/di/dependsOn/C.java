package com.examples.ioc.di.dependsOn;


import org.springframework.stereotype.Component;

@Component("C")
public class C {
    public C() {
        System.out.printf("C initialized %s \n", InitSeq.getAndIncrementSequence());
    }
}
