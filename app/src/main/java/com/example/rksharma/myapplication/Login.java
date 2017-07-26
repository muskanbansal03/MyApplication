package com.example.rksharma.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends AppCompatActivity {

    EditText username;
    EditText password;
    Button login;
    Button forgot_pass;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.et1);
        password = (EditText) findViewById(R.id.et2);
        login = (Button) findViewById(R.id.b1);
        forgot_pass = (Button) findViewById(R.id.b2);
        register = (Button) findViewById(R.id.b3);
    }

    public void loggedIn(View view)
    {

        try
        {
            DatabaseHandler d1 = new DatabaseHandler(Login.this);
            Boolean status = d1.checkUser(username.getText().toString(), password.getText().toString());
            Boolean status1 = d1.paymentUser(username.getText().toString());
            if(status == true && status1 == true)
            {
                Intent intent = new Intent(Login.this, PayedHome.class);
                startActivity(intent);
            }
            else
                if(status == true && status1 == false)
                {
                    Intent intent = new Intent(Login.this, Home.class);
                    startActivity(intent);
                }
            else
                if(status == false)
                {
                    Toast.makeText(getApplicationContext(), "NOT REGISTERED USER", Toast.LENGTH_SHORT).show();
                }
            else
                Toast.makeText(getApplicationContext(), "NOT WORKING", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"CnT",Toast.LENGTH_SHORT).show();
        }
    }
    public void newUser(View view)
    {
        try
        {
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"Cnt",Toast.LENGTH_SHORT).show();
        }
    }
    public void pass(View view)
    {
        try
        {
            Intent intent = new Intent(Login.this, Forgot_password.class);
            startActivity(intent);
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"Cnt",Toast.LENGTH_SHORT).show();
        }
    }
}
