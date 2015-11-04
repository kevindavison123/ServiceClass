package mobile.davison.service;

import android.content.Context;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Kevin on 10/28/2015.
 * This class is actually not used and should be deleted. But is a nice reference.
 */
public class UserFunction
{
    private static String loginURL = "needs to be implemented";
    private static String registerURL = "needs to be implemented";
    private static String formULR = "needs to be implemented";
    private static String change_passwordURL = "needs to be implemented";
    private static String forgot_passwordURL = "needs to be implemented";

    JSONParser jsonParser;
    private static String login_tag = "login";
    private static String register_tag = "register";
    private static String form_tag = "form";
    private static String forgotpassword_tag = "forgot password";
    private static String changepassword_tag = "change password";

    public UserFunction()
    {
        jsonParser = new JSONParser();
    }

    public JSONObject loginPostUser(String email, String password)
    {
        HashMap<String, String> params = new HashMap<>();
        params.put("tag", login_tag);
        params.put("email", email);
        params.put("password", password);
        JSONObject json = jsonParser.makeHttpRequest(loginURL,"POST",params);
        return json;
    }

    public JSONObject loginGetUser(String email, String password)
    {
        HashMap<String, String> params = new HashMap<>();
        params.put("tag", login_tag);
        params.put("email", email);
        params.put("password", password);
        JSONObject json = jsonParser.makeHttpRequest(loginURL,"GET",params);
        return json;
    }

    public JSONObject registerPostUser(String fname, String lname,String email, String password)
    {
        HashMap<String, String> params = new HashMap<>();
        params.put("tag", register_tag);
        params.put("fname", fname);
        params.put("lname", lname);
        params.put("email", email);
        params.put("password", password);
        JSONObject json = jsonParser.makeHttpRequest(loginURL,"POST",params);
        return json;
    }

    public JSONObject registerGetUser(String fname, String lname,String email, String password)
    {
        HashMap<String, String> params = new HashMap<>();
        params.put("tag", register_tag);
        params.put("fname", fname);
        params.put("lname", lname);
        params.put("email", email);
        params.put("password", password);
        JSONObject json = jsonParser.makeHttpRequest(loginURL,"GET",params);
        return json;
    }

    public JSONObject sumbitPostForm(String group,String subject, String description, String date, String email)
    {
        HashMap<String, String> params = new HashMap<>();
        params.put("tag", form_tag);
        params.put("group", group);
        params.put("subject", subject);
        params.put("description", description);
        params.put("date", date);
        params.put("email", email);
        JSONObject json = jsonParser.makeHttpRequest(loginURL,"POST",params);
        return json;

    }

    public JSONObject sumbitGetForm(String group,String subject, String description, String date, String email)
    {
        HashMap<String, String> params = new HashMap<>();
        params.put("tag", form_tag);
        params.put("group", group);
        params.put("subject", subject);
        params.put("description", description);
        params.put("date", date);
        params.put("email", email);
        JSONObject json = jsonParser.makeHttpRequest(loginURL,"GET",params);
        return json;

    }

    public JSONObject changePassword(String newpassword, String email)
    {
        HashMap<String, String> params = new HashMap<>();
        params.put("tag", changepassword_tag);
        params.put("email", email);
        params.put("newpassword", newpassword);
        JSONObject json = jsonParser.makeHttpRequest(loginURL,"POST",params);
        return json;
    }


    public JSONObject forgotPassword(String forgotPassword)
    {
        HashMap<String, String> params = new HashMap<>();
        params.put("tag", forgotpassword_tag);
        params.put("forgotpassword", forgotPassword);
        JSONObject json = jsonParser.makeHttpRequest(loginURL,"POST",params);
        return json;
    }

    public boolean logoutUser(Context context)
    {
        DatabaseHandler db = new DatabaseHandler(context);
        db.resetTables();
        return true;

    }
}
