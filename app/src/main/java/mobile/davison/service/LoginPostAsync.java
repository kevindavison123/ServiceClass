//package mobile.davison.service;
//
//import android.app.ProgressDialog;
//import android.content.ContentValues;
//import android.content.Context;
//import android.os.AsyncTask;
//import android.util.Log;
//import android.widget.Toast;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.HashMap;
//
///**
// * Created by kevin on 10/27/2015.
// *  This is unused in project 2 but will be later used in the final EventApp project
// */
//public class LoginPostAsync extends AsyncTask<String, String, JSONObject>
//{
//    private static String KEY_UID = "uid";
//    private static String KEY_FIRSTNAME = "fname";
//    private static String KEY_LASTNAME = "lname";
//    private static String KEY_EMAIL = "email";
//    private static String KEY_CREATED_AT = "created_at";
//
//
//
//    Context context = App.getContext();
//    JSONParser jsonParser = new JSONParser();
//    private static final String TAG_SUCESS = "success";
//    private static final String TAG_MESSAGE = "message";
//
//
//
//    private ProgressDialog pDialog;
//
//    protected void onPreExecute()
//    {
//        pDialog = new ProgressDialog(context);
//        pDialog.setMessage("Attempting Submission...");
//        pDialog.setIndeterminate(false);
//        pDialog.setCancelable(true);
//        pDialog.show();
//    }
//
//
//    @Override
//    protected JSONObject doInBackground(String... args)
//    {
//        try {
//
//           UserFunction userFunction = new UserFunction();
//            JSONObject json = userFunction.loginPostUser(args[0],args[1]);
//            if (json != null) {
//                Log.d("JSON result", json.toString());
//                return json;
//            }
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        return null;
//    }
//    protected void onPostExecute(JSONObject json) {
//        int success = 0;
//        String message ="";
//
//        if(pDialog != null && pDialog.isShowing())
//        {
//            pDialog.dismiss();
//        }
//        if(json != null)
//        {
//            Toast.makeText(context, json.toString(), Toast.LENGTH_LONG).show();
//            try {
//                success = json.getInt(TAG_SUCESS);
//                message = json.getString(TAG_MESSAGE);
//                JSONObject json_user = json.getJSONObject("user");
//                DatabaseHandler db = new DatabaseHandler(context);
//                UserFunction logout = new UserFunction();
//                //clear all previous data in SQlite database
//                logout.logoutUser(context);
//                db.addUser(json_user.getString(KEY_FIRSTNAME), json_user.getString(KEY_LASTNAME), json_user.getString(KEY_EMAIL), json_user.getString(KEY_UID), json_user.getString(KEY_CREATED_AT));
//            } catch (JSONException e)
//            {
//                e.printStackTrace();
//            }
//        }
//        if(success == 1)
//        {
//            Log.d("Success!", message);
//        }
//        else{
//            Log.d("Failure!", message);
//        }
//
//    }
//}
//
