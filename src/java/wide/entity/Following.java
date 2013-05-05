
package wide.entity;

import java.util.List;

/**
 * Interficie que fa referencia a una entitat que es seguida per una altre entitat
 * @author cuarti
 */
public interface Following {
    
    public List<Follower> getFollowersList();
    public void setFollowersList(List<Follower> followersList);
    
}
