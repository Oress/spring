package com.examples.ioc.resources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

@Component
public class ResourceBean {

    // This way we can inject a resource into a bean
    public ResourceBean(@Value("${urlprop}") Resource url) {
        System.out.printf("ResourceBean constructor %s \n", url.getDescription());
        testUrlResource();
        testClassPathResource();
    }

    private static void testUrlResource() {
        try {
            System.out.println("\n\n ResourceBean Teststing UrlResource \n\n");
            Resource res = new UrlResource("https://www.google.com");
            BufferedReader isr = new BufferedReader(new InputStreamReader(res.getInputStream()));
            isr.lines().limit(5).forEach(System.out::println);
            System.out.println("\n\n");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void testClassPathResource() {
        try {
            System.out.println("\n\n ResourceBean Teststing ClassPathResource \n\n");
            Resource res = new ClassPathResource("customprops.my");
            BufferedReader isr = new BufferedReader(new InputStreamReader(res.getInputStream()));
            isr.lines().limit(5).forEach(System.out::println);
            System.out.println("\n\n");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
