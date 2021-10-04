package service.impl;

import dao.AbstractDao;
import dao.GenericDao;
import model.Bucket;
import model.Product;
import model.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    public UserServiceImpl() {
        GenericDao<User, Long> dao = new AbstractDao<>(User.class);
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User read(Long id) {
        return null;
    }

    @Override
    public User update(User bucket) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<User> readAll() {
        return null;
    }
}
