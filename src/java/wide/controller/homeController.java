
package wide.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@UrlBinding("/public/simple_math/{$event}/{number=5}")
@WebServlet(name = "homeController", urlPatterns = {"/home"})
public class homeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        request.setAttribute("homeDisabled", true);
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
    
}
