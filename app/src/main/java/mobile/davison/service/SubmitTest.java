package mobile.davison.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
/*
This IS used for project 2 all commented code is to be used in EventApp but NOT in project 2 to get rid of confusion.
 */

public class SubmitTest extends AppCompatActivity {
//    Button buttonLoadImage;
//    ImageView uploadImage;
    Button submitButton;
    EditText name;
    EditText subject;
    EditText groupName;
    DatePicker date;
    TimePicker time;
    EditText description;
//    private static int RESULT_LOAD_IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_submit_test);
        name = (EditText) findViewById(R.id.yourName);
        groupName = (EditText) findViewById(R.id.groupName);
        subject = (EditText) findViewById(R.id.subjectName);
        date = (DatePicker) findViewById(R.id.datePicker);
        time = (TimePicker) findViewById(R.id.timePicker);
        description = (EditText) findViewById(R.id.editText);
        //uploadImage = (ImageView) findViewById(R.id.imgView);
        submitButton = (Button) findViewById(R.id.submitButton);
        //buttonLoadImage =(Button) findViewById(R.id.loadImageButton);
//        buttonLoadImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(i, RESULT_LOAD_IMAGE);
//            }
//        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              String getName =  name.getText().toString();
                String getGroupName = groupName.getText().toString();
                String getSubject = subject.getText().toString();
               int day =  date.getDayOfMonth();
                int month = date.getMonth();
                int year = date.getYear();
                String theDate = month + 1 + "/" + day + "/" + year;
                int hour = time.getCurrentHour();
                int minute = time.getCurrentMinute();
                String minutes = String.valueOf(minute);
                if(hour > 12)
                {
                    hour = time.getCurrentHour()-12;
                }
                if(minute < 10)
                {
                    minutes = "0" + minutes;
                }
                String theTime = hour + ":" + minutes;
                String getDescription = description.getText().toString();
                FormPostAsync post = new FormPostAsync();
                new ServiceClass().formPost(getName,getGroupName,getSubject,theDate,theTime,getDescription);


                Toast.makeText(SubmitTest.this, "Event created ",
                        Toast.LENGTH_LONG).show();

//                Bitmap image = ((BitmapDrawable) uploadImage.getDrawable()).getBitmap();
//                String name = groupName.getText().toString() + dateFormat.format(date);
//                    upload(image,name);

            }
        });
    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode,Intent data)
//    {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data)
//        {
//            Uri selectedImage = data.getData();
//            uploadImage.setImageURI(selectedImage);
//        }
//    }

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

//    private void upload(Bitmap image, String name)
//    {
//        PicturePostAsync imagePost = new PicturePostAsync();
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        image.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
//        String encodedImage = Base64.encodeToString(byteArrayOutputStream.toByteArray(),Base64.DEFAULT);
//        imagePost.execute(encodedImage,name);
//    }
//    public void back()
//    {
//        Intent intent = new Intent(SubmitTest.this, Minimal.class);
//        SubmitTest.this.startActivity(intent);
//    }


}
