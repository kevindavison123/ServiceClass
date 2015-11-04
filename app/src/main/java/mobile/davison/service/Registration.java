package mobile.davison.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText email;
    EditText password;
    EditText confirmPassword;
    Button register;
    Button backToLog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        App.setContext(this);

        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.rPassword);
        confirmPassword = (EditText) findViewById(R.id.cPassword);
        register = (Button) findViewById(R.id.rRegister);
        backToLog = (Button) findViewById(R.id.backToLog);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!firstName.getText().toString().equals("") && !lastName.getText().toString().equals("") && !email.getText().toString().equals("") && !password.getText().toString().equals("") && !confirmPassword.getText().toString().equals(""))
                {
                    if(password.getText().toString().equals(confirmPassword.getText().toString())) {
                        RegistrationPostAsync post = new RegistrationPostAsync();
                        post.execute(firstName.getText().toString(), lastName.getText().toString(),email.getText().toString(),password.getText().toString());
                    }
                    else
                        Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                }
                if(firstName.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "First name is empty", Toast.LENGTH_SHORT).show();
                }
                if(lastName.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Last name is  empty", Toast.LENGTH_SHORT).show();

                }
                if(email.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Email is  empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
        backToLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(v.getContext(),Minimal.class);
                startActivityForResult(login,0);
                finish();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registration, menu);
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
