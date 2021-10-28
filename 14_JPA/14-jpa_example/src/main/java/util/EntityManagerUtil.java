package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Objects;

public class EntityManagerUtil {
    private static EntityManagerFactory managerFactory;
    private static EntityManager entityManager;

    private static EntityManagerFactory getManagerFactory() {
        return managerFactory = Persistence.createEntityManagerFactory("AppStorePersistence");
    }

    public static EntityManager getEntityManager() {
        if (Objects.isNull(managerFactory)) {
            managerFactory = getManagerFactory();
            entityManager = managerFactory.createEntityManager();
        }
        return managerFactory.createEntityManager();
    }
}
