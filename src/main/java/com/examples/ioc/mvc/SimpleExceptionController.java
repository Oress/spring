package com.examples.ioc.mvc;

import jakarta.annotation.PostConstruct;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exception")
public class SimpleExceptionController {

/*    HttpRequestMethodNotSupportedException
405 (SC_METHOD_NOT_ALLOWED)
    HttpMediaTypeNotSupportedException
415 (SC_UNSUPPORTED_MEDIA_TYPE)
    HttpMediaTypeNotAcceptableException
406 (SC_NOT_ACCEPTABLE)
    MissingPathVariableException
500 (SC_INTERNAL_SERVER_ERROR)
    MissingServletRequestParameterException
400 (SC_BAD_REQUEST)
    MissingServletRequestPartException
400 (SC_BAD_REQUEST)
    ServletRequestBindingException
400 (SC_BAD_REQUEST)
    ConversionNotSupportedException
500 (SC_INTERNAL_SERVER_ERROR)
    TypeMismatchException
400 (SC_BAD_REQUEST)
    HttpMessageNotReadableException
400 (SC_BAD_REQUEST)
    HttpMessageNotWritableException
500 (SC_INTERNAL_SERVER_ERROR)
    MethodArgumentNotValidException
400 (SC_BAD_REQUEST)
    BindException
400 (SC_BAD_REQUEST)
    NoHandlerFoundException
404 (SC_NOT_FOUND)
    AsyncRequestTimeoutException
503 (SC_SERVICE_UNAVAILABLE)*/


    @GetMapping("not-allowed")
    public String notAllowed() throws HttpMediaTypeNotSupportedException {
        throw new HttpMediaTypeNotSupportedException("Not allowed");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("tests");
    }

}
