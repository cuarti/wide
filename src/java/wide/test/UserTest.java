
package wide.test;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import wide.database.UserService;
import wide.database.UserServiceBuilder;
import wide.model.User;

public class UserTest {
    public static void main(String[] args) {
        
        EntityManager em = Persistence.createEntityManagerFactory("widePU").createEntityManager();
        EntityTransaction tr = em.getTransaction();
        UserService us = UserServiceBuilder.newInstance(em).newUserService();
        
//        tr.begin();
//        us.createUser("cuarti", "cuarti1992@gmail.com", "00000");
//        tr.commit();
        
        User user = us.findUserByName("cuarti");
        System.out.println("User finded: " + user);
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("New description: ");
        String description = entrada.nextLine();
        
        user.setDescription(description);
        
        tr.begin();
        us.updateUser(user);
        tr.commit();
        
        System.out.println("Changes added.");
        
        user = us.findUserByName("cuarti");
        System.out.println("User finded: " + user);
        
    }
}
