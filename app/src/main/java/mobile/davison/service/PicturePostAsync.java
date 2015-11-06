//package mobile.davison.service;
//
//import android.app.ProgressDialog;
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
// * Created by kevin on 11/3/2015.
// *  This is kinda wrong because this just needs to go up to a server and be placed into a folder so no JSONObject is needed but we need
// *  to host a public server at some point.
// *   This is unused in project 2 but will be later used in the final EventApp project
// */
//public class PicturePostAsync extends AsyncTask<String, String, JSONObject>
//{
//    Context context = App.getContext();
//    JSONParser jsonParser = new JSONParser();
//    private static final String LOGIN_URL = "this needs to be implemented";
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
//        pDialog.setMessage("Attempting add Picture...");
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
//            HashMap<String, String> params = new HashMap<>();
//            params.put("name", args[0]);
//            params.put("image", args[1]);
//
//            Log.d("request", "starting");
//
//            JSONObject json = jsonParser.makeHttpRequest(LOGIN_URL, "POST", params);
//
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
//    protected void onPostExecute(JSONObject json)
//    {
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
