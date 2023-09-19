package com.examples.ioc.di.autowired.qualifiedAnnotation;


public class SampleBean {
    private final String name;

    public SampleBean(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SampleBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
