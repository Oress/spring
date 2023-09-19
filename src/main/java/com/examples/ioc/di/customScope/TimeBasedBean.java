package com.examples.ioc.di.customScope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("timeBased")
public class TimeBasedBean {
}
