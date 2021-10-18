package servlet;

import lombok.SneakyThrows;
import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class RegistrationServlet extends HttpServlet {

    private static UserService service;

    public RegistrationServlet() {
        service = new UserServiceImpl();
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        if (Objects.isNull(service.readByEmail(email))) {
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String password = req.getParameter("password");
            service.create(new User(email, password, firstName, lastName, "USER"));

            HttpSession session = req.getSession(true);
            session.setAttribute("userName", firstName);
            session.setAttribute("userEmail", email);
        }
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("Success");
    }
}
