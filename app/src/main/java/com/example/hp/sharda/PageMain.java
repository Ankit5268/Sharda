package com.example.hp.sharda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PageMain extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    EditText usr1;
    EditText usr2;
    EditText pass1;
    EditText pass2;
    Button Fbtn;
    Button Sbtn;
    Button abt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_main);
        usr1 = (EditText) findViewById(R.id.user1);
        pass1 = (EditText) findViewById(R.id.pass1);
        usr2 = (EditText) findViewById(R.id.user2);
        pass2 = (EditText) findViewById(R.id.pass2);
        Fbtn = (Button) findViewById(R.id.Fbtn);
        Sbtn = (Button) findViewById(R.id.Sbtn);
        abt = (Button) findViewById(R.id.abt);

        Fbtn.setOnClickListener(new View.OnClickListener()
        {
            public  void onClick(View view) {


                if(usr1.getText().toString().equals("admin") && pass1.getText().toString().equals("admin") )
                {
                    Toast.makeText(getApplicationContext(), "Login", Toast.LENGTH_LONG);
                    Intent myIntent = new Intent(PageMain.this, FacultyLogin.class);
                    startActivity(myIntent);
                }
                else
                {
                    Toast temp = Toast.makeText(PageMain.this, "Password or Email Does Not Match !",Toast.LENGTH_LONG);
                    temp.show();
                }


            }

        });

        Sbtn.setOnClickListener(new  View.OnClickListener()
        {
            public  void onClick(View view)
            {
                if(usr2.getText().toString().equals("student") && pass2.getText().toString().equals("student") ) {
                    Toast.makeText(getApplicationContext(), "Login", Toast.LENGTH_LONG);
                    Intent myIntent = new Intent(PageMain.this, StudentLogin.class);
                    startActivity(myIntent);

                }
                else
                {
                    Toast temp = Toast.makeText(PageMain.this, "Password or Email Does Not Match !",Toast.LENGTH_LONG);
                    temp.show();
                }
            }
        });

        abt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "About", Toast.LENGTH_LONG);
                Intent myIntent = new Intent(PageMain.this, About.class);
                startActivity(myIntent);
            }
        });


    }
}
