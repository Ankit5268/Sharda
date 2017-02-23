package com.example.hp.sharda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    EditText name;
    EditText email;
    EditText cemail;
    EditText phone;
    EditText id;
    EditText batch;
    EditText degree;
    EditText stream;
    EditText pwd1;
    EditText pwd2;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        cemail = (EditText) findViewById(R.id.cemail);
        phone = (EditText) findViewById(R.id.phone);
        id = (EditText) findViewById(R.id.id);
        batch = (EditText) findViewById(R.id.batch);
        degree = (EditText) findViewById(R.id.degree);
        stream = (EditText) findViewById(R.id.stream);
        pwd1 = (EditText) findViewById(R.id.pwd1);
        pwd2 = (EditText) findViewById(R.id.pwd2);
        register = (Button) findViewById(R.id.reg);

        register.setOnClickListener(new View.OnClickListener() {

        String name1 = name.getText().toString();
        String email1 = email.getText().toString();
        String cemail1 = cemail.getText().toString();
        String phone1 = phone.getText().toString();
        String id1 = id.getText().toString();
        String batch1 = batch.getText().toString();
        String degree1 = degree.getText().toString();
        String stream1 = stream.getText().toString();
        String pwd11= pwd1.getText().toString();
        String pwd12 = pwd2.getText().toString();
    @Override
    public void onClick(View v) {


        if (!email1.equals(cemail1) && !pwd11.equals(pwd12)) {
            Toast pass = Toast.makeText(Register.this, "Password or Email Does Not Match !", Toast.LENGTH_LONG);
            pass.show();

        } else {
            Contacts c = new Contacts();
            c.setName(name1);
            c.setEmail(name1);
            c.setCemail(name1);
            c.setPhone(phone1);
            c.setId(id1);
            c.setBatch(batch1);
            c.setDegree(degree1);
            c.setStream(stream1);
            c.setPwd1(pwd11);
            c.setPwd2(pwd12);

            helper.insert(c);


        }
    }
        });

    }
}

