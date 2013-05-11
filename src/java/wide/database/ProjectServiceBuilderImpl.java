
package wide.database;

import javax.persistence.EntityManager;

/**
 *
 * @author cuarti
 */
public class ProjectServiceBuilderImpl extends ProjectServiceBuilder {
    
    public ProjectServiceBuilderImpl(EntityManager em) {
        setEntityManager(em);
    }
}
