
package wide.model;

import java.util.List;

/**
 * Interficie que fa referencia a una entitat que es seguida per una altre entitat
 * @author cuarti
 */
public interface Following {
    
    public List<Follower> getFollowers();
    public void setFollowers(List<Follower> followers);
    
}
