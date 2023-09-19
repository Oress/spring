package com.examples.ioc.di.profile;

import org.springframework.core.env.PropertySource;
import org.springframework.core.env.PropertySources;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CustomPropertySources extends PropertySource<Map<String, String>> {
    Map<String, String> props = new HashMap<>();

    // very simplistic but
    public CustomPropertySources(String fileName) {
        super(fileName);
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);

        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            try {
                List<String> lines = new BufferedReader(new InputStreamReader(new FileInputStream(resource.getFile()))).lines().toList();
                for (String line : lines) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        props.put(parts[0], parts[1]);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Object getProperty(String name) {
        return props.get(name);
    }
}
