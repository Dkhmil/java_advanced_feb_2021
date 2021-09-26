package service.imp;

import dao.Blog;
import dao.User;
import exception.DuplicateBlogException;
import exception.NoSuchBlogException;
import jdbc.MySqlConnector;

import org.apache.log4j.Logger;
import service.BlogService;
import service.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogServiceImpl implements BlogService {
    private static final Logger logger = Logger.getLogger(BlogServiceImpl.class);
    private static Connection connection;
    private static UserService userService = new UserServiceImpl();

    static {
        try {
            connection = MySqlConnector.getConnection();
            logger.debug("connection to the db was established");
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("was not able connect to the DB due to:", e);
        }
    }

    @Override
    public List<Blog> getAll() throws SQLException {
        List<Blog> blogs = new ArrayList<>();
        logger.info("get all blogs operation has begun .....");
        try (Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery("SELECT * FROM web.blogs")) {
            while (result.next()) {
                blogs.add(new Blog(result.getInt("id"), result.getString("blogName")));
            }
            logger.info("count of blogs returned ");
            return blogs;
        }
    }

    @Override
    public Blog getBlogById(int id) throws SQLException, NoSuchBlogException {
        ResultSet result = null;
        logger.info("getBlog by id with id: " + id);
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM web.blogs WHERE id = ?")) {
            statement.setInt(1, id);
            result = statement.executeQuery();
            if (result.next()) {
                return new Blog(result.getInt("id"), result.getString("name"));
            } else throw new NoSuchBlogException("No blog with id : " + id);
        } finally {
            result.close();
        }
    }

    @Override
    public void createBlog(Blog blog) throws SQLException {
        if (isExists(blog.getId())) {
            try {
                throw new DuplicateBlogException("Blog with id : " + blog.getId() + " already exists!");
            } catch (DuplicateBlogException e) {
                logger.error("try to create blog with existing id", e);
            }
        } else {
            logger.info("Creating user with id : " + blog.getId());
            userService.createUser(new User(blog.getId(), "user : " + blog.getBlogName()));
            logger.info("Creating blog with id : " + blog.getId());
            try (PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO web.blogs (id, blogName) VALUES (?, ?)")) {
                statement.setInt(1, blog.getId());
                statement.setString(2, blog.getBlogName());
                statement.execute();
            }
        }
    }


    private boolean isExists(int blogId) throws SQLException {
        boolean flag = false;
        for (Blog blog : getAll()) {
            flag = blog.getId() == blogId;
        }
        return flag;
    }
}
