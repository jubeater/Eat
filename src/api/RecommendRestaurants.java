package api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jubeater on 12/25/16.
 */
@WebServlet(name = "RecommendRestaurants")
public class RecommendRestaurants extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONArray array = new JSONArray();
        try {
            if (request.getParameterMap().containsKey("user_id")) {
                array.put(new JSONObject().put("name", "Panda Express").put("location","downtown").put("country","united states"));
                array.put(new JSONObject().put("name", "Hong Kong Express").put("location","uptown").put("country","united states"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RpcParser.writeOutput(response, array);
    }
}
