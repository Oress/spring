package com.examples.ioc.di.injection;

// The Spring initialization will fail when you uncomment the @Component annotation
// In this case we have an ambiguity, because Spring has 2 candidates for the dependency of type Dependency2
//@Component
public class ConstructorResolutionAmbiguity {
    private final Dependency1 dep1;
    private final Dependency2 dep2;

    public ConstructorResolutionAmbiguity(Dependency1 dep1, Dependency2 dep2) {
        this.dep1 = dep1;
        this.dep2 = dep2;
    }
}
