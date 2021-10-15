package service.impl;

import dao.UserDaoImpl;
import model.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDaoImpl dao;

    public UserServiceImpl() {
        dao = new UserDaoImpl(User.class);
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
    public User readByEmail(String email) {
        return dao.findUserByEmail(email);
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
        return dao.readAll();
    }


}
