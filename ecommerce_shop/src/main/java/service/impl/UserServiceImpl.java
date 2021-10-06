package service.impl;

import dao.AbstractDao;
import dao.GenericDao;
import model.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final GenericDao<User, Long> dao;

    public UserServiceImpl() {
        dao = new AbstractDao<>(User.class);
    }

    @Override
    public User create(User user) {
        return dao.create(user);
    }

    @Override
    public User read(Long id) {
        return dao.read(id);
    }

    @Override
    public User update(User bucket) {
        return dao.update(bucket);
    }

    @Override
    public void delete(Long id) {
       dao.delete(id);
    }

    @Override
    public List<User> readAll() {
        return null;
    }
}
