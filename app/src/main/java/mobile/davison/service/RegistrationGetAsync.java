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
 * Created by Kevin on 10/28/2015.
 */
public class RegistrationGetAsync extends AsyncTask<String, String, JSONObject> {

    Context context = App.getContext();
    JSONParser jsonParser = new JSONParser();

    private ProgressDialog pDialog;

    private static final String REGISTRATION_URL = "http://10.0.3.2:8080/";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    @Override
    protected void onPreExecute() {
        pDialog = new ProgressDialog(context);
        pDialog.setMessage("Attempting login...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();
    }

    @Override
    protected JSONObject doInBackground(String... args) {

        try {


            HashMap<String, String> params = new HashMap<>();
            params.put("fname", args[0]);
            params.put("lname", args[1]);
            params.put("email", args[2]);
            params.put("password", args[3]);

            Log.d("request", "starting");

            JSONObject json = jsonParser.makeHttpRequest(
                    REGISTRATION_URL, "GET", params);

            if (json != null) {
                Log.d("JSON result", json.toString());

                return json;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    protected void onPostExecute(JSONObject json) {

        int success = 0;
        String message = "";

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
