package com.examples.ioc;

import com.examples.ioc.di.profile.CustomPropertySourceInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BeanFactoryExample {
    public static void main(String[] args) {
        new SpringApplicationBuilder(BeanFactoryExample.class)
                .profiles("dev")
                .initializers(new CustomPropertySourceInitializer())
                .run(args);
    }
}
