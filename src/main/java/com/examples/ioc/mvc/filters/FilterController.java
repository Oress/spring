package com.examples.ioc.mvc.filters;

import jakarta.servlet.ServletRequest;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("filter")
public class FilterController {

    // The PUT method is not usually used for sending Form Data.
    @PutMapping("put-form-data")
    public void nonConventionalFormData(ServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        System.out.printf("login: %s, password: %s", login, password);
    }

    @RequestMapping()
    public void test () {

    }
}
