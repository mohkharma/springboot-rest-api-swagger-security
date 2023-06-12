package com.springboot.blog.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//This class to handle the error of un-authorized request
//A custom AuthenticationEntryPoint can be used to set necessary
// response headers, content-type, and so on before sending the response
// back to the client.
/*
If the user requests a secure HTTP resource without being authenticated,
AuthenticationEntryPoint will be called.
At this time, an AuthenticationException is thrown, commence() method on the entry point is triggered
 Simply, handles AuthenticationException.
 */
//@Component is a generic stereotype for any Spring-managed component.
// @Service annotates classes at the service layer.
// @Repository annotates classes at the persistence layer,
// which will act as a database repository.
//Stereotype annotations are a set of specialized annotations that are used
// to indicate the role or purpose of a particular component within the
// application.

@Component
public class JwtAuthenticationEntryPoint
        implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    }
}
