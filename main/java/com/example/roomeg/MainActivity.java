package com.example.roomeg;

import android.arch.persistence.room.Room;
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

public class MainActivity extends AppCompatActivity {

    private EditText name_signup, email_signup, mobile_signup, password_signup,id_signup;
    private TextView login_txt;
//    private TextView display_info;
    private Button signupbtn;

    public static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        id_signup = findViewById(R.id.id_signup);
        login_txt = findViewById(R.id.login_txt);
        name_signup = findViewById(R.id.name_signup);
        email_signup= findViewById(R.id.email_signup);
        mobile_signup= findViewById(R.id.mobile_signup);
        password_signup= findViewById(R.id.password_signup);

        myAppDatabase= Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"userdb").allowMainThreadQueries().build();

        login_txt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                return false;
            }
        });

        signupbtn= findViewById(R.id.signupbtn);

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                int u_id = Integer.parseInt(id_signup.getText().toString());
                String username = name_signup.getText().toString();
                String email = email_signup.getText().toString();
                int mobile = Integer.parseInt(mobile_signup.getText().toString());
                String password = password_signup.getText().toString();

                User user = new User();
//                user.setId(u_id);
                user.setName(username);
                user.setEmail(email);
                user.setMobile(mobile);
                user.setPassword(password);

                MainActivity.myAppDatabase.myDao().addUser(user);
                Toast.makeText(getApplicationContext(), "User Added Successfully", Toast.LENGTH_SHORT).show();

//                id_signup.setText("");
                name_signup.setText("");
                email_signup.setText("");
                mobile_signup.setText("");
                password_signup.setText("");

                Intent login = new Intent(MainActivity.this,Login.class);
                startActivity(login);
            }
        });
    }
}