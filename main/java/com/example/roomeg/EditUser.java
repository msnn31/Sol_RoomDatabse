package com.example.roomeg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.roomeg.MainActivity.myAppDatabase;

public class EditUser extends AppCompatActivity {

    private EditText update_userid, update_name, update_email, update_mobile, update_pass;

    private Button update_userbtn, update_cancelbtn;

    String name, email, pass;
    int id, mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        Intent intent = getIntent();
        String email_details = intent.getStringExtra("email_value");

        update_userid = findViewById(R.id.update_userid);
        update_name = findViewById(R.id.update_name);
        update_email = findViewById(R.id.update_email);
        update_mobile = findViewById(R.id.update_mobile);
        update_pass = findViewById(R.id.update_pass);
        update_cancelbtn = findViewById(R.id.update_cancelbtn);

        User usr = myAppDatabase.myDao().SpecificUser(email_details);

        for (int i = 0; i <= usr.getId(); i++) {

            name = usr.getName();
            id = usr.getId();
            email = usr.getEmail();
            mobile = usr.getMobile();
            pass = usr.getPassword();
        }

        update_name.setText(String.valueOf(name));
        update_userid.setText(String.valueOf(id));
        update_email.setText(String.valueOf(email));
        update_mobile.setText(String.valueOf(mobile));
        update_pass.setText(String.valueOf(pass));

        update_userbtn = findViewById(R.id.update_userbtn);

        update_userbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id = Integer.parseInt(update_userid.getText().toString());
                String name = update_name.getText().toString();
                String email = update_email.getText().toString();
                int mobile = Integer.parseInt(update_mobile.getText().toString());
                String password = update_pass.getText().toString();

                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);
                user.setMobile(mobile);
                user.setPassword(password);

                MainActivity.myAppDatabase.myDao().updateUser(user);
                Toast.makeText(EditUser.this, "User Updated....", Toast.LENGTH_SHORT).show();

                update_userid.setText("");
                update_name.setText("");
                update_email.setText("");
                update_mobile.setText("");
                update_pass.setText("");
            }
        });

        update_cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(EditUser.this,Home.class);
                back.putExtra("email_value",email);
                startActivity(back);
            }
        });
    }
}