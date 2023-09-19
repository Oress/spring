package com.examples.ioc.di.dependsOn;

public class InitSeq {
    private static int sequence = 1;

    public static int getAndIncrementSequence() {
        return sequence++;
    }
}
