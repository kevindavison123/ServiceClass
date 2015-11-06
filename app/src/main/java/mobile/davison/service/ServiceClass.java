package mobile.davison.service;

import android.telecom.Call;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by kevin on 10/27/2015.
 * This is
 */
public class ServiceClass {
   private JSONArray jsonArray;
    private JSONObject jsonObject;

    public ServiceClass()
    {

    }

    //    public  void loginPost(String password, String username)
//    {
//        LoginPostAsync post = new LoginPostAsync();
//        post.execute(password, username);
//    }
//
//    public  void loginGet(String password, String username)
//    {
//        LoginGetAsync get = new LoginGetAsync();
//        get.execute(password, username);
//    }
//
//    public void registrationPost()
//    {
//        RegistrationPostAsync post = new RegistrationPostAsync();
//        post.execute();
//    }
//
//    public void registrationGet()
//    {
//        RegistrationGetAsync get = new RegistrationGetAsync();
//        get.execute();
//    }
    public void formPost(String... args) {
        FormPostAsync post = new FormPostAsync();
        post.execute(args);
    }

    public void recieveJSON(Object result) {
        Log.d("SERVICE CLASS", "GET HERE");
        if (JSONArray.class.isAssignableFrom(result.getClass()))
        {
            Log.d("SERVICE CLASS", result.toString());
            this.jsonArray = (JSONArray) result;

            Log.d("Receive Json", jsonArray.toString());

            setJsonArray(this.jsonArray);
        }


    }

    private JSONArray setJsonArray(JSONArray json)
    {
        this.jsonArray = json;
        return this.jsonArray;
    }




    public JSONArray getEvents() {
        FormGetAsync get = new FormGetAsync() {
            @Override
            public void receiveData(Object result) {
                Log.d("ServiceClass", "Does this happen?");
                recieveJSON(result);

            }

            @Override
            public void recieveData(Object object) {
                Log.d("ServiceClass", "Did this happen?");
                recieveJSON(object);
            }
        };
        get.execute();
        Log.d("get events ", jsonArray.toString());
        return this.jsonArray;
    }
}
