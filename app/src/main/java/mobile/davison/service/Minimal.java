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

public class Minimal extends AppCompatActivity {

    private String tag = "Login";
    EditText uname;
    EditText password;
    Button signIn;
    Button register;
    Button forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minimal);
        App.setContext(this);
        uname = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        signIn = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.lRegister);
        forgotPassword = (Button) findViewById(R.id.forgotPass);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(v.getContext(),Registration.class);
                startActivityForResult(register,0);
                finish();
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forget = new Intent(v.getContext(),Registration.class);
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!uname.getText().toString().equals("") && !password.getText().toString().equals(""))
                {
                    new LoginGetAsync().execute(uname.getText().toString(),password.getText().toString());

                    new LoginPostAsync().execute(uname.getText().toString(),password.getText().toString());

                }
                if(uname.getText().toString().equals("") && password.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Username and password fields are empty", Toast.LENGTH_SHORT).show();
                }
                if(uname.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Username field is empty", Toast.LENGTH_SHORT).show();
                }
                if(password.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Password field is empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //I'm just calling it automatically here rn. It should be called on a button press but one thing at a time
        String username = "testuser";
        String password = "testpass";
        new LoginGetAsync().execute(username, password);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_minimal, menu);
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
