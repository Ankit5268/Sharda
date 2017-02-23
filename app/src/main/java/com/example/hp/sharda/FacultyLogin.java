package com.example.hp.sharda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FacultyLogin extends AppCompatActivity {

    Button delete;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_login);

        delete = (Button) findViewById(R.id.delete);
        update = (Button) findViewById(R.id.update);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(FacultyLogin.this,Delete.class);
                startActivity(myIntent);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(FacultyLogin.this,Update.class);
                startActivity(myIntent);
            }
        });

    }
}
