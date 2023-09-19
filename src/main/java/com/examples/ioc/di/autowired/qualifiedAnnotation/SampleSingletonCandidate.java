package com.examples.ioc.di.autowired.qualifiedAnnotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("sampleSingletonCandidate-qualifier")
public class SampleSingletonCandidate {
    private final SampleBean sampleBean;

    // IMO it would be more logical to move this configuration to the separate class though
    // but for demonstration purposes only
    public SampleSingletonCandidate(@Qualifier("secondaryConfig-qualifier") SampleBean sampleBean) {
        this.sampleBean = sampleBean;
        System.out.printf("SampleSingletonCandidate Qualifiers constructor: %s \n", sampleBean);
    }
}
