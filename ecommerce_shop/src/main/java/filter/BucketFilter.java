package filter;


import filter.service.FilterService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter("/bucket.jsp")
public class BucketFilter implements Filter {

    private FilterService filterService;

    public BucketFilter() {
        filterService = new FilterService();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterService.doFilterValidation((HttpServletRequest) servletRequest,
                (HttpServletResponse) servletResponse, filterChain, List.of("USER"));
    }

    @Override
    public void destroy() {

    }
}
