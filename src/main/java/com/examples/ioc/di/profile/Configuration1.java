package com.examples.ioc.di.profile;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// This way we can optionally enable or disable parts of the configurations.
@Profile("some_non_existing_profile")
@Configuration
public class Configuration1 {

    @Value("${prop1}")
    private String myCustomProp;

    @PostConstruct
    public void postConstruct() {
        // This method will not be called because the profile is not active
        System.out.println("Configuration1.postConstruct");
    }

}
