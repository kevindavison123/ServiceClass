package mobile.davison.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by kevin on 11/3/2015.
 * This is kinda wrong because this just needs to go up to a server and be placed into a folder so no JSONObject is needed
 */
public class PictureGetAsync extends AsyncTask<String, String, JSONObject> {

    Context context = App.getContext();
    JSONParser jsonParser = new JSONParser();

    private ProgressDialog pDialog;

    private static final java.lang.String FORM_URL = "http://10.0.3.2:8080/";
    private static final java.lang.String TAG_SUCCESS = "success";
    private static final java.lang.String TAG_MESSAGE = "message";

    @Override
    protected void onPreExecute() {
        pDialog = new ProgressDialog(context);
        pDialog.setMessage("Attempting login...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();
    }

    @Override
    protected org.json.JSONObject doInBackground(java.lang.String... args) {

        try {
            //THIS NEEDS TO BE CHANGED
            HashMap<java.lang.String, java.lang.String> params = new HashMap<>();
            params.put("name", args[0]);
            params.put("image", args[1]);

            Log.d("request", "starting");

            org.json.JSONObject json = jsonParser.makeHttpRequest(
                    FORM_URL, "GET", params);

            if (json != null) {
                Log.d("JSON result", json.toString());

                return json;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    protected void onPostExecute(org.json.JSONObject json) {

        int success = 0;
        java.lang.String message = "";

        if (pDialog != null && pDialog.isShowing()) {
            pDialog.dismiss();
        }

        if (json != null) {
            Toast.makeText(context, json.toString(),
                    Toast.LENGTH_LONG).show();

            try {
                success = json.getInt(TAG_SUCCESS);
                message = json.getString(TAG_MESSAGE);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        if (success == 1) {
            Log.d("Success!", message);
        }else{
            Log.d("Failure", message);
        }
    }

}
