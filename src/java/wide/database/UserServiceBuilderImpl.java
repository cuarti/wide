
package wide.database;

import javax.persistence.EntityManager;


public class UserServiceBuilderImpl extends UserServiceBuilder {

    public UserServiceBuilderImpl(EntityManager em) {
        setEntityManager(em);
    }
    
}
