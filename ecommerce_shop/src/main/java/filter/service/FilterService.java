package filter.service;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class FilterService {

    // цей метод фільтрує http запит (перевіряємо: user чи admin)
    public void doFilterValidation(HttpServletRequest servletRequest, HttpServletResponse servletResponse,
                                   FilterChain filterChain, List<String> allowedRoles) throws ServletException, IOException {
        HttpSession session = servletRequest.getSession();
        String role = session.getAttribute("role").toString();

        if (!role.isEmpty() && allowedRoles.contains(role)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletRequest.getRequestDispatcher("index.jsp").forward(servletRequest, servletResponse);
        }
    }

}
