
package wide.database;

import javax.persistence.EntityManager;

/**
 *
 * @author cuarti
 */
public abstract class ProjectServiceBuilder {
    
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public static ProjectServiceBuilder newInstance(EntityManager entityManager) {
        return new ProjectServiceBuilderImpl(entityManager);
    }
    
    public ProjectService newProjectService() {
        return new ProjectServiceORM(entityManager);
    }
    
}
