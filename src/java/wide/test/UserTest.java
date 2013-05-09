
package wide.test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import wide.database.UserService;
import wide.model.User;

public class UserTest {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("widePU");
        EntityManager em = emf.createEntityManager();
        
        UserService service = new UserService(em);
        
        em.getTransaction().begin();
//        
        User user1 = service.createUser("cuarti", "cuarti1992@gmail.com", "0000");
        System.out.println("user1 creat: " + user1);
//                
//        service.removeUser(user1.getId());
//        System.out.println("user1 eliminat");
//        
//        User user2 = service.createUser("albert", "1111", "aasldm2@gmail.com");
//        System.out.println("user2 creat: " + user2);
//        
        em.getTransaction().commit();
//        
//        User user3 = service.findUserById(user2.getId());
//        System.out.println("user3 trobat per id: " + user3);
//        
//        User user4 = service.findUserByName("albert");
//        System.out.println("user4 trobat per name: " + user4);
        
        User user5 = service.findUserByMail("cuarti1992@gmail.com");
        System.out.println("user5 trobat per mail: " + user5);
        
        List<User> users = service.findAllUsers();
        System.out.println("users = " + users);
        for(User u : users) {
            System.out.println("user = " + u);
        }
        
    }
}
