package servlet;

import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

public class RegistrationServlet extends HttpServlet {

    private static final UserService service;

    static {
        service = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        if (Objects.isNull(service.readByEmail(email).getEmail())) {
            String password = req.getParameter("password");
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            service.create(new User(email, password, firstName, lastName, "USER"));

            HttpSession session = req.getSession(true);
            session.setAttribute("firstName", firstName);
            session.setAttribute("email", email);
        }

        resp.setContentType("text/plain");
        resp.getWriter().write("Success");
    }
}
