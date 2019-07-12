import com.sun.net.httpserver.HttpServer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/")
public class Servlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("works");
    }
}
