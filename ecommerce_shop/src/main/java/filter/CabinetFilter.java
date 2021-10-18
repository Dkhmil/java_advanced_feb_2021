package filter;

import filter.service.FilterService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter("/cabinet.jsp")
public class CabinetFilter implements Filter {

    private FilterService service;

    public CabinetFilter() {
        service = new FilterService();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        service.doFilterValidation((HttpServletRequest) servletRequest,
                (HttpServletResponse) servletResponse,
                filterChain,
                List.of("ADMIN", "USER"));
    }

    @Override
    public void destroy() {

    }
}
