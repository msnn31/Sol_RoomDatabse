package com.example.roomeg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static com.example.roomeg.MainActivity.myAppDatabase;

public class Admin extends AppCompatActivity {

    TextView adminViewData;

    Button Logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Logout = findViewById(R.id.Logout);

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Admin.this, "Logout Successfull", Toast.LENGTH_SHORT).show();
                Intent log_out = new Intent(Admin.this,MainActivity.class);
                startActivity(log_out);
            }
        });

        adminViewData = findViewById(R.id.adminViewData);

        List<User> ur = myAppDatabase.myDao().getUsers();

        String info = "";

        for (User usr : ur)
        {
            String name = usr.getName();
            int id = usr.getId();
            String email = usr.getEmail();
            int mobile = usr.getMobile();
            String password = usr.getPassword();

            info = info+"\n"+"Id :"+id+"\n Name :"+name+"\n Email :"+email+"\n Mobile :"+mobile+"\n Password :"+password;
        }

        adminViewData.setText(info);
    }
}
