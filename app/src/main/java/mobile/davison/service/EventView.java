package mobile.davison.service;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;

public class EventView extends AppCompatActivity{
    final ServiceClass serviceClass = new ServiceClass();



    static final String[] EVENTS = new String[] {};
    Button getBdButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_view);
        getBdButton = (Button) findViewById(R.id.getDbevents);

        getBdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FormGetAsync get = new FormGetAsync() {
                    @Override
                    public void receiveData(Object result) {
                        Log.d("ServiceClass", "Does this happen?");
                         serviceClass.recieveJSON(result);

                    }

                    @Override
                    public void recieveData(Object object) {
                        Log.d("ServiceClass", "Did this happen?");
                        serviceClass.recieveJSON(object);
                    }
                };
                get.execute();

                List<String> stringList = serviceClass.setJsonArray();
            }
        });
     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public Loader onCreateLoader(int id, Bundle args) {
//        return null;
//    }
//
//    @Override
//    public void onLoaderReset(Loader loader) {
//
//    }
//
//    @Override
//    public void onLoadFinished(Loader loader, Object data) {
//
//    }
}
