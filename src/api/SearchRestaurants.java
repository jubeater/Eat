package api;

import db.DBConnection;
import db.MySQLDBConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jubeater on 12/24/16.
 */
@WebServlet(name = "SearchRestaurants")
public class SearchRestaurants extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static DBConnection connection = new MySQLDBConnection();


    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        JSONArray array = new JSONArray();
        if (request.getParameterMap().containsKey("user_id")
                && request.getParameterMap().containsKey("lat")
                && request.getParameterMap().containsKey("lon")) {
            String userId = request.getParameter("user_id");
            double lat = Double.parseDouble(request.getParameter("lat"));
            double lon = Double.parseDouble(request.getParameter("lon"));
            array = connection.searchRestaurants(userId, lat, lon);


        }
        RpcParser.writeOutput(response, array);
    }


}
