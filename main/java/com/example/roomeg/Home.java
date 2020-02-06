package com.example.roomeg;

import android.arch.persistence.room.ColumnInfo;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static com.example.roomeg.MainActivity.myAppDatabase;

public class Home extends AppCompatActivity {

    TextView uName, userId, userDisplayName, userEmail, userMobile, userPass;

    Button UserLogoutbtn, UserEditbtn, UserDeletebtn;

    String name, email, pass;
    int id, mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        String email_details = intent.getStringExtra("email_value");

//        txt = findViewById(R.id.txt);
//        txt.setText(String.valueOf(email_details));

        uName = findViewById(R.id.uName);
        userId = findViewById(R.id.userId);
        userDisplayName = findViewById(R.id.userDisplayName);
        userEmail = findViewById(R.id.userEmail);
        userMobile = findViewById(R.id.userMobile);
        userPass = findViewById(R.id.userPass);

        UserLogoutbtn = findViewById(R.id.UserLogoutbtn);
        UserEditbtn = findViewById(R.id.UserEditbtn);
        UserDeletebtn = findViewById(R.id.UserDeletebtn);


        UserLogoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Home.this, "Logout Successfully", Toast.LENGTH_SHORT).show();
                Intent logout = new Intent(Home.this, MainActivity.class);
                startActivity(logout);
            }
        });

//        User u = myAppDatabase.myDao().ViewUser();
////
//        for (int i = 0; i <= u.getId(); i++) {
//////
//////        for (User ur : usr){
////
//////
//            name = u.getName();
//            id = u.getId();
//            email = u.getEmail();
//            mobile = u.getMobile();
//            pass = u.getPassword();
//        }

//        if (email_details == email) {

        User ur = myAppDatabase.myDao().SpecificUser(email_details);

//        int uid = u.getId();

//        User ur = myAppDatabase.myDao().ViewUser();

                for (int i = 0; i <= ur.getId(); i++) {
////
////        for (User ur : usr){

            name = ur.getName();
            id = ur.getId();
            email = ur.getEmail();
            mobile = ur.getMobile();
            pass = ur.getPassword();
        }

//            int user_id = u.getId();

//        int i = 0;
//        while (i<= id) {
//
//            if (uid ==id) {

//                String my_name = name;
//                int my_id = id;
//                String my_email = email;
//                int my_mobile = mobile;
//                String my_pass = pass;

                uName.setText(String.valueOf(name));
                userDisplayName.setText("Name: " + String.valueOf(name));
                userId.setText("Id: " + String.valueOf(id));
                userEmail.setText("Email: " + String.valueOf(email));
                userMobile.setText("Mobile: " + String.valueOf(mobile));
                userPass.setText("Password: " + String.valueOf(pass));

        UserEditbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent edit = new Intent(Home.this, EditUser.class);
                edit.putExtra("email_value",email);
                startActivity(edit);
            }
        });

        UserDeletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent delete = new Intent(Home.this, Delete.class);
                delete.putExtra("email_value",email);
                startActivity(delete);
            }
        });

            }

//            i++;
        }
//        }
