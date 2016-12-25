package api;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jubeater on 12/24/16.
 */
@WebServlet(name = "SearchRestaurants")
public class SearchRestaurants extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        response.addHeader("Access-Control-Allow-Origin", "*");
        String username = "";
        PrintWriter out = response.getWriter();
        if (request.getParameter("username") != null) {
            username = request.getParameter("username");
            out.print("Hello " + username);
        }
        out.flush();
        out.close();    }
}
