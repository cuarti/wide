package wide.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wide.database.UserService;
import wide.database.UserServiceBuilder;
import wide.model.User;

@WebServlet(name = "authenticationController", urlPatterns = {"/authentication"})
public class authenticationController extends HttpServlet {

    private EntityManager em = Persistence.createEntityManagerFactory("widePU").createEntityManager();
    private EntityTransaction tr = em.getTransaction();
    private UserService us = UserServiceBuilder.newInstance(em).newUserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.getWriter().println("ASDAS");
        doPost(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        switch (request.getParameter("action")) {
            case "signIn":
                signIn(request, response);
                break;
            case "signUp":
                signUp(request, response);
                break;
            case "signOut":
                signOut(request, response);
                break;
        }
        
    }

    private void signIn(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {

        List<String> errorsList = new ArrayList<>();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        User user = us.findUserByName(username);

        if(user == null) {
            errorsList.add("The username doesn\'t exist.");
        }
        else if(!user.getPassword().equals(password)) {
            errorsList.add("The password is incorrect.");
        }
        
        if(errorsList.isEmpty()) {
            request.getSession().setAttribute("user", user);
        }
        else {
            user = null;
        }
        
        Gson gson = new Gson();
        String json = gson.toJson(new AjaxResponse(user, errorsList));
        response.getWriter().println(json);

    }
    
    private void signUp(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        
        List<String> errorsList = new ArrayList<>();
        
        String username = request.getParameter("username");
        String mail = request.getParameter("mail");
        String password = request.getParameter("password");
        
        if(username.length() < 5) {
            errorsList.add("The username length is shorter than 5.");
        }
        if(username.length() > 30) {
            errorsList.add("The username length is bigger than 30.");
        }
        if(!username.matches("[a-zA-Z0-9]*")) {
            errorsList.add("The username has special characters.");
        }
        if(us.findUserByName(username) != null) {
            errorsList.add("The username already exists.");
        }
        
        if(!mail.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            errorsList.add("The mail address is incorrect");
        }
        if(us.findUserByMail(mail) != null) {
            errorsList.add("The mail address already exists.");
        }
        
        if(password.length() < 5) {
            errorsList.add("The password length is shorter than 5.");
        }
        if(password.length() > 30) {
            errorsList.add("The password length is bigger than 30.");
        }
        if(!password.matches("[a-zA-Z0-9]*")) {
            errorsList.add("The password has special characters.");
        }
        if(!password.equals(request.getParameter("confirmPassword"))) {
            errorsList.add("The password confirmation is diferent than the password");
        }
        
        User user = null;
        
        if(errorsList.isEmpty()) {
            user = new User(username, mail, password);
            
            tr.begin();
            us.createUser(username, mail, password);
            tr.commit();
            
            request.getSession().setAttribute("user", user);
        }
        
        Gson gson = new Gson();
        String json = gson.toJson(new AjaxResponse(user, errorsList));
        response.getWriter().println(json);
    }

    private void signOut(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        
        request.getSession().invalidate();
        
    }
    
    private class AjaxResponse {
        private User user;
        private List<String> errorsList;
        
        public AjaxResponse(User user, List<String> errorsList) {
            if(user == null) {
                this.errorsList = errorsList;
            }
            else {
                this.user = user;
//                this.user.setPassword(null);
            }
        }
    }
//    
//    @Override
//    public void init() throws ServletException {
//        super.init();
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("widePU");
//        em = emf.createEntityManager();
//        tr = em.getTransaction();
//
//        UserServiceBuilder usb = UserServiceBuilder.newInstance(em);
//        us = usb.newUserService();
//
//    }
}
