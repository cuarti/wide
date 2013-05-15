package wide.controller;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import wide.database.ProjectService;
import wide.database.ProjectServiceBuilder;
import wide.database.UserService;
import wide.database.UserServiceBuilder;
import wide.exceptions.files.NotDirectoryFileException;
import wide.model.Project;
import wide.model.User;
import wide.utilities.FilesUtilities;

@WebServlet(name = "projectController", urlPatterns = {"/project"})
public class projectController extends HttpServlet {

    private EntityManager em = Persistence.createEntityManagerFactory("widePU").createEntityManager();
    private EntityTransaction tr = em.getTransaction();
    private ProjectService ps = ProjectServiceBuilder.newInstance(em).newProjectService();
    private UserService us = UserServiceBuilder.newInstance(em).newUserService();
    private FilesUtilities fu = FilesUtilities.newInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        switch (request.getParameter("action")) {
            case "createProject":
                createProject(request, response);
                break;
            default:
        }
    }

    private void createProject(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String title = request.getParameter("title").trim();
        Long userId = ((User) session.getAttribute("userSession")).getId();
        User user = us.findUserById(userId);
        
        if (title == null || title.isEmpty()) {
            request.setAttribute("messageResponse", "The project title can't be empty.");
        } else if (user.hasProject(title)) {
            request.setAttribute("messageResponse", "The project title already exists.");
        } else {
            try {

                tr.begin();
                Project project = ps.createProject(title, user);
                user.addProject(project);
                us.updateUser(user);
                tr.commit();       

                fu.createProjectDirectory(project);
                session.setAttribute("userSession", user);
                request.setAttribute("messageResponse", "The project has been created successfully.");
                
            } catch (Exception ex) {
                tr.rollback();
                request.setAttribute("messageResponse", "Has ocurred a problem. Please try it again later.");
            }
        }
        request.setAttribute("user", user);
        request.getRequestDispatcher("userProfile.jsp").forward(request, response);

    }
}
