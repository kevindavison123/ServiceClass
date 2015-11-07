package mobile.davison.service;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Kevin on 10/28/2015.
 * This class is actually not used and should be deleted. But is a nice reference.
 */
public class EventFunction
{
    private static String createEventURL = "http://10.0.3.2:8080/events/create";
    private static String deleteEventURL = "http://10.0.3.2:8080/events/delete";
    private static String getWeeklyEventsURL = "http://10.0.3.2:8080/events/weeklyevents";
    private static String getAllEventsURL = "http://10.0.3.2:8080/events/allevents";

    JSONParser jsonParser;
    private static String login_tag = "login";
    private static String register_tag = "register";
    private static String form_tag = "form";
    private static String forgotpassword_tag = "forgot password";
    private static String changepassword_tag = "change password";

    public EventFunction()
    {
        jsonParser = new JSONParser();
    }

    public void createEventPost(int authorId, String photoLocation, String description,
                                      String title, String location, String date, String time)
    {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("authorId", authorId);
            jsonObject.put("photoLocation", photoLocation);
            jsonObject.put("description", description);
            jsonObject.put("title", title);
            jsonObject.put("location", location);
            jsonObject.put("date", date);
            jsonObject.put("time", time);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonParser.postJSONObject(createEventURL, jsonObject);
    }

    public void deleteEvent(int eventToDeleteId) {
        jsonParser.deleteEvent(deleteEventURL, eventToDeleteId);
    }

}
