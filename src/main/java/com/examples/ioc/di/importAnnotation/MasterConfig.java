package com.examples.ioc.di.importAnnotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// useful when there is no component scan in the project
@Import({Config1.class, Config2.class})
@Configuration
public class MasterConfig {
}
