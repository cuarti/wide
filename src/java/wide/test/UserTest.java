package wide.test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import wide.database.ProjectService;
import wide.database.ProjectServiceBuilder;
import wide.database.UserService;
import wide.database.UserServiceBuilder;
import wide.model.Project;
import wide.model.User;

public class UserTest {

    public UserTest() {
    }
    
    public void addProject() {
        
    }

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("widePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        UserService us = UserServiceBuilder.newInstance(em).newUserService();
        ProjectService ps = ProjectServiceBuilder.newInstance(em).newProjectService();

        User user = us.findUserByName("cuarti");

//        /*Create user*/
//        tr.begin();
//        User user = us.createUser("cuarti", "cuarti1992@gmail.com", "00000");
//        tr.commit();
        
//        /*Create project*/
//        tr.begin();
//        Project project = ps.createProject("project", user);
//        /*Add project to user*/
//        user.addProject(project);
//        user = us.updateUser(user);
//        tr.commit();

        System.out.println("User finded: " + user);

//        Project project = user.getProjects().get(1);
//        
//        System.out.println(project);

    }
}
