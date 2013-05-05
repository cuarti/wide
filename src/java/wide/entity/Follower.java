
package wide.entity;

import java.util.List;

/**
 * Interficie que fa referencia a una entitat que segueix altres entitats
 * @author cuarti
 */
public interface Follower {
    
    public List<Following> getFollowingList();
    public void setFollowingList(List<Following> followingList);
    
}
