package servlet.controller;

import com.google.gson.Gson;
import model.Bucket;
import model.User;
import model.response.ProductResponse;
import service.BucketProductService;
import service.BucketService;
import service.UserService;
import service.impl.BucketProductServiceImpl;
import service.impl.BucketServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet("/bucketInfo")
public class BucketController extends HttpServlet {
    private UserService userService;
    private BucketService bucketService;
    private BucketProductService bucketProductService;

    public BucketController() {
        userService = new UserServiceImpl();
        bucketService = new BucketServiceImpl();
        bucketProductService = new BucketProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = session.getAttribute("userEmail").toString();
        User user = userService.readByEmail(email);
        int bucketId = user.getId();
        List<ProductResponse> productResponseList = bucketProductService.getProductsByBucketId(bucketId);

        String json = new Gson().toJson(productResponseList);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("productId"));
        HttpSession session = req.getSession();
        String email = session.getAttribute("userEmail").toString();
        User user = userService.readByEmail(email);
        int bucketId = user.getId();
        if (Objects.isNull(bucketService.read((long) bucketId))) {
            Bucket bucket = new Bucket(bucketId);
        }
        bucketProductService.addProductToBucket(bucketId, productId);

        resp.setContentType("plain/text");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("Success");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("productId"));
        HttpSession session = req.getSession();
        String email = session.getAttribute("userEmail").toString();
        User user = userService.readByEmail(email);
        int bucketId = user.getId();
        boolean allParameter = Boolean.parseBoolean(req.getParameter("all"));

        bucketProductService.removeProductFromBucket(bucketId, productId, allParameter);

        resp.setContentType("plain/text");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("Success");

    }
}
