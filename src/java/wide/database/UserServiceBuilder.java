
package wide.database;

import javax.persistence.EntityManager;

public abstract class UserServiceBuilder {
    
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public static UserServiceBuilder newInstance(EntityManager entityManager) {
        return new UserServiceBuilderImpl(entityManager);
    }
    
    public UserService newUserService() {
        return new UserServiceORM(entityManager);
    }
    
}
