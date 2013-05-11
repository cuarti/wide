
package wide.database;

import java.util.List;
import wide.model.User;

public interface UserService {

    public User createUser(String name, String mail, String password);

    public void updateUser(User user);
    
    public void removeUser(Long id);

    public User findUserById(Long id);

    public User findUserByName(String name);

    public User findUserByMail(String mail);

    public List<User> findAllUsers();
    
}
