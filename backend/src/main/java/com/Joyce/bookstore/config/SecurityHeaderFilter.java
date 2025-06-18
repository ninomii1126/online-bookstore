package com.Joyce.bookstore.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SecurityHeaderFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Cross-Origin-Opener-Policy", "same-origin");
        httpResponse.setHeader("Cross-Origin-Embedder-Policy", "require-corp");

        chain.doFilter(request, response);
    }
}
