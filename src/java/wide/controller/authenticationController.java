 package wide.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = us.findUserByName(username);

        Gson gson = new GsonBuilder().create();
        JsonObject json = new JsonObject();
        JsonArray errorsList = new JsonArray();
        
        if (user == null) {
            errorsList.add(new JsonPrimitive("The username doesn\'t exist."));
        } else if (!user.getPassword().equals(password)) {
            errorsList.add(new JsonPrimitive("The password is incorrect."));
        }
        
        if(errorsList.size() == 0) {
            HttpSession session = request.getSession();
            session.setAttribute("userSession", user);
            
            json.add("username", new JsonPrimitive(username));
        } else {
            json.add("errors", errorsList);
        }
        response.getWriter().println(gson.toJson(json));

    }

    private void signUp(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        
        String username = request.getParameter("username");
        String mail = request.getParameter("mail");
        String password = request.getParameter("password");

        Gson gson = new GsonBuilder().create();
        JsonObject json = new JsonObject();
        JsonArray errorsList = new JsonArray();
        
        if (username.length() < 5) {
            errorsList.add(new JsonPrimitive("The username length is shorter than 5."));
        }
        if (username.length() > 30) {
            errorsList.add(new JsonPrimitive("The username length is bigger than 30."));
        }
        if (!username.matches("[a-zA-Z0-9]*")) {
            errorsList.add(new JsonPrimitive("The username has special characters."));
        }
        if (us.findUserByName(username) != null) {
            errorsList.add(new JsonPrimitive("The username already exists."));
        }

        if (!mail.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            errorsList.add(new JsonPrimitive("The mail address is incorrect"));
        }
        if (us.findUserByMail(mail) != null) {
            errorsList.add(new JsonPrimitive("The mail address already exists."));
        }

        if (password.length() < 5) {
            errorsList.add(new JsonPrimitive("The password length is shorter than 5."));
        }
        if (password.length() > 30) {
            errorsList.add(new JsonPrimitive("The password length is bigger than 30."));
        }
        if (!password.matches("[a-zA-Z0-9]*")) {
            errorsList.add(new JsonPrimitive("The password has special characters."));
        }
        if (!password.equals(request.getParameter("confirmPassword"))) {
            errorsList.add(new JsonPrimitive("The password confirmation is diferent than the password"));
        }

        if (errorsList.size() == 0) {

            tr.begin();
            User user = us.createUser(username, mail, password);
            tr.commit();

            request.getSession().setAttribute("userSession", user);
            json.add("username", new JsonPrimitive(username));
        }
        else {
            json.add("errors", errorsList);
        }

        response.getWriter().println(gson.toJson(json));
    }

    private void signOut(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        request.getSession().invalidate();

    }
}
