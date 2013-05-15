
package wide.model;

import java.util.List;

/**
 * Interficie que fa referencia a una entitat que segueix altres entitats
 * @author cuarti
 */
public interface Follower {
    
    public List<Following> getFollowing();
    public void setFollowing(List<Following> following);
    
}
