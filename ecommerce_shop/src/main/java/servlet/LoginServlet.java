package servlet;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import model.User;
import service.UserService;
import service.impl.UserServiceImpl;
import util.UserLogin;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static UserService service;

    public LoginServlet() {
        service = new UserServiceImpl();
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        User user = service.readByEmail(email);

        if (!Objects.isNull(user)) {
            String password = req.getParameter("password");
            if (password.equals(user.getPassword())) {
                UserLogin userLogin = new UserLogin(email, "cabinet.jsp");

                HttpSession session = req.getSession(true);
                session.setAttribute("userName", user.getFirstName());
                session.setAttribute("userEmail", email);
                session.setAttribute("role", user.getRole());

                String json = new Gson().toJson(userLogin);
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(json);
            }
        }

    }
}
