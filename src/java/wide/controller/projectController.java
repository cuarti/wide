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
        User user = (User) session.getAttribute("user");

        if (title == null || title.isEmpty()) {
            request.setAttribute("error", "The title project can't be empty.");
        } else if (user.hasProject(title)) {
            request.setAttribute("error", "The title project already exists");
        } else {
            response.getWriter().println("Starts the data persistence.");
//            try {
//                tr.begin();
//                
//                Project project = ps.createProject(title, user);
//                response.getWriter().println("Project created: " + project);
//                user.addProject(project);
//                us.updateUser(user);
//                response.getWriter().println("User updated: " + user);
//
//                session.setAttribute("user", user);
//                fu.createProject(project.getId());
//                
//                tr.commit();
//                response.getWriter().println("Commit did");
//            } catch (NotDirectoryFileException | SecurityException | IOException ex) {
//                tr.rollback();
//                response.getWriter().println(ex.getMessage());
//            }
//            response.getWriter().println("Ends the persistence.");
        }
        response.getWriter().println(request.getAttribute("error"));
        response.getWriter().println(user.getProjects());
//        request.getRequestDispatcher("projects.jsp").forward(request, response);

    }

//    @Override
//    public void init() throws ServletException {
//        super.init();
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("widePU");
//        em = emf.createEntityManager();
//        tr = em.getTransaction();
//
//        ProjectServiceBuilder psb = ProjectServiceBuilder.newInstance(em);
//        ps = psb.newProjectService();
//
//        UserServiceBuilder usb = UserServiceBuilder.newInstance(em);
//        us = usb.newUserService();
//
//        fu = FilesUtilities.newInstance();
//    }
}
