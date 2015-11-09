package mobile.davison.service;

import android.content.Context;
import android.telecom.Call;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

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
    private Context context = App.getContext();
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
    public void formGetAll(LinearLayout linearLayout)
    {
        String url = "events/allevents";
        FormGetAsync get = new FormGetAsync();
        get.get(linearLayout,url);
    }
    public void formGetWeekly(LinearLayout linearLayout)
    {
        String url = "events/weeklyevents";
        FormGetAsync get = new FormGetAsync();
        get.get(linearLayout,url);
    }


}
