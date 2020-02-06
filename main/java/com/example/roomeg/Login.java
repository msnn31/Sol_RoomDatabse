package com.example.roomeg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static com.example.roomeg.MainActivity.myAppDatabase;

public class Login extends AppCompatActivity {

    private TextView signuptxtLogin;
    private EditText emailLogin, passLogin;
    private Button LoginbtnLogin;

    String name, email, pass;
    int id, mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailLogin = findViewById(R.id.emailLogin);
        passLogin = findViewById(R.id.passLogin);

        signuptxtLogin = findViewById(R.id.signuptxtLogin);

        signuptxtLogin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                Intent main = new Intent(Login.this,MainActivity.class);
                startActivity(main);
                return false;
            }
        });

        LoginbtnLogin = findViewById(R.id.LoginbtnLogin);

        LoginbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<User> ur = myAppDatabase.myDao().getUsers();

                for (User usr : ur)
                {
                    name = usr.getName();
                    id = usr.getId();
                    email = usr.getEmail();
                    mobile = usr.getMobile();
                    pass = usr.getPassword();
                }

                String email_value = emailLogin.getText().toString();
                String pass_value = passLogin.getText().toString();

                if (email_value.equals(email) && pass_value.equals(pass))
                {
                    Intent home = new Intent(Login.this, Home.class);
                    home.putExtra("email_value",email_value);
                    startActivity(home);
                    emailLogin.setText("");
                    passLogin.setText("");
                }

                else if (email_value.equals("admin@abc.com") && pass_value.equals("admin"))
                {
                    Intent admin = new Intent(Login.this, Admin.class);
                    startActivity(admin);
                }

                else {
                    Toast.makeText(Login.this, "Wrong Email and Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
