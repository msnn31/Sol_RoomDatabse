package com.example.roomeg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import static com.example.roomeg.MainActivity.myAppDatabase;

public class ViewUsers extends AppCompatActivity {

    String name, email, pass;
    int id, mobile;

    private TextView view_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);

        view_details  = findViewById(R.id.view_details);

        List<User> ur = myAppDatabase.myDao().getUsers();

        String info = "";

        for (User usr : ur)
        {
            name = usr.getName();
            id = usr.getId();
            email = usr.getEmail();
            mobile = usr.getMobile();

//            for (int userid= 0; userid<= id; userid++)
//            {
//                if (email_details.equals(email))
//                {
//                    display_Username.setText(name);
//                    userdetailsname.setText(name);
//                    userdetailsemail.setText(email);
//                    userdetailsmobile.setText(mobile);
//                }
//            }
            info = info+"\n\n"+"Id :"+id+"\n Name :"+name+"\n Email :"+email+"\n Mobile :"+mobile;
        }

        view_details.setText(info);
    }
}
