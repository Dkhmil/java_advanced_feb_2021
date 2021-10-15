package service;

import model.User;

import java.util.List;

public interface UserService {

    User create(User user);

    User read(Long id);

    User readByEmail(String email);

    User update(User bucket);

    void delete(Long id);

    List<User> readAll();
}
