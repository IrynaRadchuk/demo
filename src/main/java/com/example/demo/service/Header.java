package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletRequest;

@Component
@RequestScope
public class Header {

    private static final String CURRENT_USER_HEADER = "db";

    @Autowired
    private HttpServletRequest httpServletRequest;

    public String getHeader() {
        return httpServletRequest.getHeader(CURRENT_USER_HEADER) ;
    }
}