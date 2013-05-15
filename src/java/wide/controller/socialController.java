
package wide.controller;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wide.database.ProjectService;
import wide.database.ProjectServiceBuilder;
import wide.database.UserService;
import wide.database.UserServiceBuilder;
import wide.model.Project;
import wide.model.User;
import wide.utilities.ProjectUtilities;

@WebServlet(name = "socialController", urlPatterns = {"/social"})
public class socialController extends HttpServlet {

    private EntityManager em = Persistence.createEntityManagerFactory("widePU").createEntityManager();
    private ProjectUtilities up = ProjectUtilities.newInstance();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("socialDisabled", true);
        
        if (request.getParameter("action") != null) {
            switch (request.getParameter("action")) {
                case "user":
                    userProfile(request, response);
                    break;
                case "project":
                    projectProfile(request, response);
                    break;
                default:
                    indexSocial(request, response);
            }
        }
        else {
            indexSocial(request, response);
        }
    }
    
    private void indexSocial(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("social.jsp").forward(request, response);
    }

    private void userProfile(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        UserServiceBuilder usb = UserServiceBuilder.newInstance(em);
        UserService service = usb.newUserService();
        
        String username = request.getParameter("value");
        
        User user = service.findUserByName(username);
        
        request.setAttribute("user", user);
        request.getRequestDispatcher("userProfile.jsp").forward(request, response);
    }
    
    private void projectProfile(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        ProjectServiceBuilder psb = ProjectServiceBuilder.newInstance(em);
        ProjectService pService = psb.newProjectService();
        
        Long id = Long.decode(request.getParameter("value"));
        
        Project project = pService.findProjectById(id);
        
        List<Project> relationalProjects = up.getRelationalProjects(project);
        
        request.setAttribute("project", project);
        request.setAttribute("otherProjects", relationalProjects);
        
        request.getRequestDispatcher("project.jsp").forward(request, response);
    }
}
