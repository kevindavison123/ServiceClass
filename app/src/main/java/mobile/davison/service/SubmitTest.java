package mobile.davison.service;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SubmitTest extends AppCompatActivity {
    ImageView uploadImage;
    Button submitButton;
    EditText titleText;
    EditText descriptionText;
    EditText locationText;
    DatePicker dateBox;
    TimePicker timeBox;

    Button deleteButton;
    EditText eventToDeleteIdText;
    private static int RESULT_LOAD_IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.setContext(this);
        Intent intent = getIntent();
        setContentView(R.layout.activity_submit_test);
        submitButton = (Button) findViewById(R.id.submitButton);
        titleText = (EditText) findViewById(R.id.title);
        descriptionText = (EditText) findViewById(R.id.description);
        locationText = (EditText) findViewById(R.id.location);
        dateBox = (DatePicker) findViewById(R.id.datePicker);
        timeBox = (TimePicker) findViewById(R.id.timePicker);

        deleteButton = (Button) findViewById(R.id.deleteButton);
        eventToDeleteIdText = (EditText) findViewById(R.id.deleteEventId);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleText.getText().toString();
                String description = descriptionText.getText().toString();
                String location = locationText.getText().toString();
                String date = dateBox.getYear() + "-" + dateBox.getMonth() + "-" + dateBox.getDayOfMonth();
                String time = timeBox.getCurrentHour()+ ":" + timeBox.getCurrentMinute() + ":" + "00";
                postEventToDatabase(title, description, location, date, time);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View v) {
                String eventId = eventToDeleteIdText.getText().toString();
                deleteEventFromDatabase(eventId);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data)
        {
            Uri selectedImage = data.getData();
            uploadImage.setImageURI(selectedImage);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_submit_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return super.onOptionsItemSelected(item);
    }

    private void upload(Bitmap image, String name)
    {
        PicturePostAsync imagePost = new PicturePostAsync();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        String encodedImage = Base64.encodeToString(byteArrayOutputStream.toByteArray(),Base64.DEFAULT);
        imagePost.execute(encodedImage,name);
    }

    private void postEventToDatabase(String title, String description, String location, String date, String time) {
        new CreateEventPostAsync().execute("1", "foo/bar", description, title, location,
                date, time);
    }

    private void deleteEventFromDatabase(String eventToDeleteId) {
        new EventDeleteAsync().execute(eventToDeleteId);
    }

    public void back()
    {
        Intent intent = new Intent(SubmitTest.this, Minimal.class);
        SubmitTest.this.startActivity(intent);
    }


}
