package com.example.roomeg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.roomeg.MainActivity.myAppDatabase;

public class Delete extends AppCompatActivity {

    private EditText delete_userid;
    private Button delete_userbtn;

    String name, email, pass;
    int uid, mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        Intent intent = getIntent();
        final String email_details = intent.getStringExtra("email_value");

        delete_userid = findViewById(R.id.delete_userid);
        delete_userbtn = findViewById(R.id.delete_userbtn);

        User ur = myAppDatabase.myDao().SpecificUser(email_details);

        for (int i = 0; i <= ur.getId(); i++) {

            name = ur.getName();
            uid = ur.getId();
            email = ur.getEmail();
            mobile = ur.getMobile();
            pass = ur.getPassword();
        }

        delete_userid.setText(String.valueOf(uid));

        delete_userbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User user = new User();
                user.setId(uid);
                MainActivity.myAppDatabase.myDao().deleteUser(user);

                Toast.makeText(Delete.this, "User Successfully deleted...!!!", Toast.LENGTH_SHORT).show();
                delete_userid.setText("");
            }
        });
    }
}
