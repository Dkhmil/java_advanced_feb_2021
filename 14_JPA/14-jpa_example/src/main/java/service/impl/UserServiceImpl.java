package service.impl;

import model.User;
import service.UserService;
import util.EntityManagerUtil;

import javax.persistence.EntityManager;

public class UserServiceImpl implements UserService {
    private EntityManager entityManager;

    @Override
    public void createUser(User user) {
        entityManager = EntityManagerUtil.getEntityManager();
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }
}
