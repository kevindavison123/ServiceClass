package mobile.davison.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kevin on 10/27/2015.
 */
public class CreateEventPostAsync extends AsyncTask<String, String, JSONObject>
{
    private static String KEY_UID = "uid";
    private static String KEY_FIRSTNAME = "fname";
    private static String KEY_LASTNAME = "lname";
    private static String KEY_EMAIL = "email";
    private static String KEY_CREATED_AT = "created_at";



    Context context = App.getContext();
    JSONParser jsonParser = new JSONParser();
    private static final String TAG_SUCESS = "success";
    private static final String TAG_MESSAGE = "message";

    private ProgressDialog pDialog;

    protected void onPreExecute()
    {
        pDialog = new ProgressDialog(context);
        pDialog.setMessage("Attempting to Create an Event...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();
    }


    @Override
    protected JSONObject doInBackground(String... args)
    {
        try {

            EventFunction eventFunction = new EventFunction();
            eventFunction.createEventPost(Integer.valueOf(args[0]), args[1], args[2], args[3],
                    args[4], args[5], args[6]);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    protected void onPostExecute(JSONObject json) {
        int success = 0;
        String message ="";

        if(pDialog != null && pDialog.isShowing())
        {
            pDialog.dismiss();
        }
    }
}

