package wide.database;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import wide.model.User;

public class UserService {

    protected EntityManager em;

    public UserService(EntityManager em) {
        this.em = em;
    }

    public User createUser(String name, String mail, String password) {
        User user = new User(name, mail, password);
        em.persist(user);
        return user;
    }

    public void removeUser(Long id) {
        User user = findUserById(id);
        if (user != null) {
            em.remove(user);
        }
    }

    public User findUserById(Long id) {
        return em.find(User.class, id);
    }

    public User findUserByName(String name) {
        try {
            TypedQuery<User> query = em.createQuery("SELECT u from User u WHERE u.name = ?1", User.class);
            return query.setParameter(1, name).getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public User findUserByMail(String mail) {
        try {
            TypedQuery<User> query = em.createQuery("SELECT u from User u WHERE u.mail = ?1", User.class);
            return query.setParameter(1, mail).getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public List<User> findAllUsers() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }
}
