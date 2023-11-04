package br.com.paulo.todolist.filter;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class FilterTaskAuth implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {

        // Executar alguma ação
        chain.doFilter(request, response);
    }
}
