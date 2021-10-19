package servlet;

import lombok.SneakyThrows;
import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static UserService service;

    public LoginServlet() {
        service = new UserServiceImpl();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        User user = service.readByEmail(email);

        if (!Objects.isNull(user.getEmail()) && user.getId() != 0) {
            String password = req.getParameter("password");
            if (password.equals(user.getPassword())) {
                HttpSession session = req.getSession(true);
                session.setAttribute("userName", user.getFirstName());
                session.setAttribute("userEmail", email);
                session.setAttribute("role", user.getRole());
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");

                RequestDispatcher requestDispatcher = req.getRequestDispatcher("cabinet.jsp");
                try {
                    requestDispatcher.forward(req, resp);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
