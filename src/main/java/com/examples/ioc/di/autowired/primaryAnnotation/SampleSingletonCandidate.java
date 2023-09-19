package com.examples.ioc.di.autowired.primaryAnnotation;

import org.springframework.stereotype.Component;

@Component
public class SampleSingletonCandidate {
    private final SampleBean sampleBean;

    public SampleSingletonCandidate(SampleBean sampleBean) {
        this.sampleBean = sampleBean;
        System.out.printf("SampleSingletonCandidate constructor: %s \n", sampleBean);
    }
}
