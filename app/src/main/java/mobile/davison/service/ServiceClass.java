package mobile.davison.service;

import android.telecom.Call;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
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

            this.jsonArray = (JSONArray) result;

            Log.d("Receive Json", jsonArray.toString());

            setJsonArray(this.jsonArray);
        }


    }

    public  List<String> setJsonArray(JSONArray json)
    {
        List<String> stringList = new ArrayList<>();
        this.jsonArray = json;
        Log.d("Set Json", jsonArray.toString());
        for(int i =0; i<jsonArray.length(); i++)
        {
            try {
                JSONObject jObj= jsonArray.getJSONObject(i);

                Log.d("Object", jObj.toString());
                Iterator<String> it = jObj.keys();
                while(it.hasNext())
                {
                    String stringId = it.next();
                    String value = jObj.get(stringId).toString();
                    Log.d("String", stringId);
                    Log.d("String", value);
                    stringList.add(value);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return stringList;
    }




    public JSONArray getEvents() {
        Log.d("get events ", this.jsonArray.toString());
        return this.jsonArray;
    }
}
