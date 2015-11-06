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
// * Created by Kevin on 10/28/2015.
// *  This is unused in project 2 but will be later used in the final EventApp project
// */
//public class LoginGetAsync extends AsyncTask<String, String, JSONObject> {
//
//        Context context = App.getContext();
//        JSONParser jsonParser = new JSONParser();
//
//        private ProgressDialog pDialog;
//
//        private static final String LOGIN_URL = "http://10.0.3.2:8080/";
//        private static final String TAG_SUCCESS = "success";
//        private static final String TAG_MESSAGE = "message";
//
//        @Override
//        protected void onPreExecute() {
//            pDialog = new ProgressDialog(context);
//            pDialog.setMessage("Attempting login...");
//            pDialog.setIndeterminate(false);
//            pDialog.setCancelable(true);
//            pDialog.show();
//        }
//
//        @Override
//        protected JSONObject doInBackground(String... args) {
//
//            try {
//
//                //We don't need params really... Only the last part is a param and i harcoded it for
//                //now because i couldn't get it to format right....
//                HashMap<String, String> params = new HashMap<>();
////                params.put("name", args[0]);
////                params.put("password", args[1]);
//
//                Log.d("request", "starting");
//
//                //Debug it here and you can see what has been returned in the JSON object
//                JSONObject json = jsonParser.makeHttpRequest(
//                        LOGIN_URL + "test/event/3", "GET", params);
//
//                if (json != null) {
//                    Log.d("JSON result", json.toString());
//
//                    return json;
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            return null;
//        }
//
//        protected void onPostExecute(JSONObject json) {
//
//            int success = 0;
//            String message = "";
//
//            if (pDialog != null && pDialog.isShowing()) {
//                pDialog.dismiss();
//            }
//
//            if (json != null) {
//                Toast.makeText(context, json.toString(),
//                        Toast.LENGTH_LONG).show();
//
//                try {
//                    success = json.getInt(TAG_SUCCESS);
//                    message = json.getString(TAG_MESSAGE);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            if (success == 1) {
//                Log.d("Success!", message);
//            }else{
//                Log.d("Failure", message);
//            }
//        }
//
//    }
//
