package service;

import model.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    User read(int id);

    void delete(int id);

    List<User> findAll();

    User readByEmail(String email);
}
