package com.examples.ioc.mvc.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("controller")
public class SampleRestController {

    @GetMapping("query")
    public String queryParameter(@RequestParam String param) {
        return String.format("Hello, query %s", param);
    }

    @GetMapping("path/{param}")
    public String pathParameter(@PathVariable String param) {
        return String.format("Hello, path %s", param);
    }

    // GET /matrix/42;q=11;r=22
    @GetMapping("/matrix/{petId}")
    public String matrixParameter(@PathVariable String petId, @MatrixVariable String q, @MatrixVariable String p ) {
        return String.format("Hello, matrix %s %s", p, q);
    }

    @PostMapping("/model-attribute")
    public String modelAttribute(@ModelAttribute SignupForm signupForm) {
        return String.format("Hello, obtained  data: %s", signupForm);
    }

    @PostMapping("/files/{path}")
    public ResponseEntity upload() {
        return ResponseEntity
                .status(HttpStatus.MOVED_PERMANENTLY)
                .header(HttpHeaders.LOCATION, "newUrl")
                .build();
    }

    @PostMapping("/upload")
    public String bigFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            System.out.printf("I have received some bytes = %s", bytes.length);
            return "redirect:uploadSuccess";
        }
        return "redirect:uploadFailure";
    }

    @GetMapping("/exception")
    public String exception() {
        throw new IllegalArgumentException("Something went wrong");
    }

    // This is a 'local' exception handler ->
    // it will only handle exceptions thrown from this controller and only those which inherit from RuntimeException
    @ExceptionHandler
    public ResponseEntity<String> handle(IOException ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Ha Ha HaHa Ha " + ex.getMessage());
    }

}
