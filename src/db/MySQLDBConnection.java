package db;

/**
 * Created by jubeater on 12/25/16.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.Restaurant;

import org.json.JSONArray;
import org.json.JSONObject;

import yelp.YelpAPI;

public class MySQLDBConnection implements DBConnection {
    // May ask for implementation of other methods. Just add empty body to them.

    @Override
    public void close() {

    }

    @Override
    public void setVisitedRestaurants(String userId, List<String> businessIds) {

    }

    @Override
    public void unsetVisitedRestaurants(String userId, List<String> businessIds) {

    }

    @Override
    public Set<String> getVisitedRestaurants(String userId) {
        return null;
    }

    @Override
    public JSONObject getRestaurantsById(String businessId, boolean isVisited) {
        return null;
    }

    @Override
    public JSONArray recommendRestaurants(String userId) {
        return null;
    }

    @Override
    public Set<String> getCategories(String businessId) {
        return null;
    }

    @Override
    public Set<String> getBusinessId(String category) {
        return null;
    }

    @Override
    public JSONArray searchRestaurants(String userId, double lat, double lon) {
        try {
            // Connect to Yelp API
            YelpAPI api = new YelpAPI();
            JSONObject response = new JSONObject(
                    api.searchForBusinessesByLocation(lat, lon));
            JSONArray array = (JSONArray) response.get("businesses");

            List<JSONObject> list = new ArrayList<>();

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                // Clean and purify
                Restaurant restaurant = new Restaurant(object);
                // return clean restaurant objects
                JSONObject obj = restaurant.toJSONObject();
                list.add(obj);
            }
            return new JSONArray(list);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Boolean verifyLogin(String userId, String password) {
        return null;
    }

    @Override
    public String getFirstLastName(String userId) {
        return null;
    }
}
