package service.impl;

import model.User;
import service.UserService;
import util.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final EntityManager entityManager;

    public UserServiceImpl() {
        this.entityManager = EntityManagerUtil.getEntityManager();
    }

    @Override
    public void createUser(User user) {
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public User read(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void delete(int id) {
        User user = read(id);
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("SELECT u FROM User u").getResultList();
    }

    @Override
    public User readByEmail(String email) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> from = criteriaQuery.from(User.class);
        criteriaQuery.select(from);
        criteriaQuery.where(criteriaBuilder.equal(from.get("email"), email));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
/*        return (User) entityManager
                .createQuery(String.format("SELECT * FROM USERS WHERE USER_EMAIL = %s", email))
                .getSingleResult();*/
    }


}
