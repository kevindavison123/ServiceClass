package mobile.davison.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.loopj.android.http.*;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.entity.StringEntity;

/**
 * Created by Kevin on 10/28/2015.
 *
 */
public class FormGetAsync {
    private static final String FORM_URL = "http://10.0.3.2:8080/";
    private  AsyncHttpClient client = new AsyncHttpClient();
    private static Context context = App.getContext();

    public void postJSON(JSONObject jsonObject, String url) {
        String search = FORM_URL + url;

        StringEntity entity = null;
        try {
            entity = new StringEntity(jsonObject.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        client.post(context, search, entity, "application/json", new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject object) {

            }
        });
    }

    public void deleteEvent(int eventId, String url) {
        String search = FORM_URL + url + "/" + eventId;

        client.delete(search, new JsonHttpResponseHandler() {

        });

    }

    public void get(final LinearLayout linearLayout, String url) {
        String search = FORM_URL+url;



        client.get(search, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject jsonObject) {
                Toast.makeText(context, "Success!", Toast.LENGTH_LONG).show();

                Toast.makeText(context, jsonObject.toString(), Toast.LENGTH_LONG).show();

            }

            public void onSuccess(int statusCode, Header[] headers, JSONArray jsonArray) {


                for(int i = 0; i<jsonArray.length(); i++)
                {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Iterator<String> it = jsonObject.keys();
                        String value = "";
                        List<TextView> textViews = new ArrayList();
                        while(it.hasNext())
                        {
                            String name = it.next();
                            value = jsonObject.get(name).toString();
                            TextView rowTextView = new TextView(context);
                            rowTextView.setText(value);
                            textViews.add(rowTextView);
                            linearLayout.addView(rowTextView);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }


                Log.d("omg android", jsonArray.toString());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject error) {
                Toast.makeText(context, "Error: " + statusCode + " " + throwable.getMessage(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray error) {
                Toast.makeText(context, "Error: " + statusCode + " " + throwable.getMessage(), Toast.LENGTH_LONG).show();
            }

        });

    }
}