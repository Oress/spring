package com.examples.ioc.di.customScope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

// The TimeBased scoped object will 'die' after 10 seconds
public class TimeBasedScope implements Scope {
    private static final long TTL = 10 * 1000L;
    private final Object lock = new Object();

    private Map<String, Instant> expireAtTime = new HashMap<>();

    private Map<String, Object> scopedObjects = new HashMap<>();
    private Map<String, Runnable> destructionCallbacks = new HashMap<String, Runnable>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        synchronized (lock) {
            Object object = scopedObjects.get(name);
            Instant now = Instant.now();
            if (object == null || now.isAfter(expireAtTime.get(name))) {
                object = objectFactory.getObject();
                scopedObjects.put(name, object);
                expireAtTime.put(name, now.plus(TTL, ChronoUnit.MILLIS));
            }
            return object;
        }
    }

    @Override
    public Object remove(String name) {
        return scopedObjects.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        destructionCallbacks.put(name, callback);
    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
