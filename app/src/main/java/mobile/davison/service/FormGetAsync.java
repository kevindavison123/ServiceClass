package mobile.davison.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Kevin on 10/28/2015.
 */
public abstract class FormGetAsync extends AsyncTask<String, String, JSONArray> implements  CallbackReceiver{
    Context context = App.getContext();
    JSONArrayParser jsonParser = new JSONArrayParser();

    private ProgressDialog pDialog;

    private static final String FORM_URL = "http://10.0.2.2:8080/";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

public abstract void recieveData(Object object);
    @Override
    protected void onPreExecute() {
//        pDialog = new ProgressDialog(context);
//        pDialog.setMessage("Attempting login...");
//        pDialog.setIndeterminate(false);
//        pDialog.setCancelable(true);
//        pDialog.show();
    }

    @Override
    protected JSONArray doInBackground(String... args) {

        try {
            //THIS NEEDS TO BE CHANGED
            HashMap<String, String> params = new HashMap<>();
//            params.put("name", args[0]);
//            params.put("group", args[1]);
//            params.put("subject", args[2]);
//            params.put("date", args[3]);
//            params.put("time", args[4]);
//            params.put("description", args[5]);

            Log.d("request", "starting");

            JSONArray json = jsonParser.makeHttpRequest(
                    FORM_URL + "events/allevents", "GET", params);


            if (json != null) {
                Log.d(" ASYNC TASK JSON result", json.toString());
                receiveData(json);
                return json;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("JSON PARSER", "returned null");
        return null;
    }

    protected void onPostExecute(JSONArray json) {


//        if (pDialog != null && pDialog.isShowing()) {
//            pDialog.dismiss();
//        }

        if (json != null) {

        }
    }

}
