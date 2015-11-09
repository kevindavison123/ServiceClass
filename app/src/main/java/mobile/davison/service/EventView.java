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
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EventView extends AppCompatActivity {
    final ServiceClass serviceClass = new ServiceClass();
    private LinearLayout linearLayout;


    static final String[] EVENTS = new String[]{};
    Button getBdButton;
    Button getWeeklyButton;
    Button getDeleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.setContext(EventView.this);
        setContentView(R.layout.activity_event_view);
        getBdButton = (Button) findViewById(R.id.getDbevents);
        getWeeklyButton = (Button) findViewById(R.id.getWeekly);
        getDeleteButton = (Button) findViewById(R.id.deleteSomeone);
        linearLayout = (LinearLayout) findViewById(R.id.linearText);
        getBdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                linearLayout.removeView(v);
                serviceClass.formGetAll(linearLayout);
            }

        });
        getWeeklyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.removeView(v);
                serviceClass.formGetWeekly(linearLayout);
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


}