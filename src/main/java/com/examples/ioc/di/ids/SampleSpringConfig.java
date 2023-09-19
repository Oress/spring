package com.examples.ioc.di.ids;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleSpringConfig {

    // the first one is primary, the rest are aliases
    @Bean(name = {"sampleSingleton", "ssAlias1", "ssAlias2"})
    public SampleSingleton sampleSingleton() {
        return new SampleSingleton();
    }

    @Bean
    public String sampleStringBean(@Qualifier("sampleSingleton") SampleSingleton obj1,
                                   @Qualifier("ssAlias1") SampleSingleton obj2) {
        if(obj1 == obj2) {
            System.out.println("obj1 and obj2 are the same object");
        } else {
            System.out.println("obj1 and obj2 are different objects");
        }
        return ";";
    }
}
