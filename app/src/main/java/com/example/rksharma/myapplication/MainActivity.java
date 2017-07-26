package com.example.rksharma.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button submit;
    Button reset;
    EditText name;
    EditText username;
    EditText password;
    EditText reEnter;
    EditText college;
    EditText mobile;
    EditText email;
    EditText payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = (Button) findViewById(R.id.b1);
        reset = (Button) findViewById(R.id.b2);
        name = (EditText) findViewById(R.id.et1);
        username = (EditText) findViewById(R.id.et2);
        password = (EditText) findViewById(R.id.et3);
        reEnter = (EditText) findViewById(R.id.et4);
        college = (EditText) findViewById(R.id.et5);
        mobile = (EditText) findViewById(R.id.et6);
        email = (EditText) findViewById(R.id.et7);
        payment = (EditText) findViewById(R.id.et8);


    }
    public void register(View view)
    {
          String name1 = name.getText().toString();
        String username1 = username.getText().toString();
        String password1 = password.getText().toString();
        String reenter1 = reEnter.getText().toString();
        String college1 = college.getText().toString();
        String mobile1 = mobile.getText().toString();
        String email1 = email.getText().toString();
        String payment1 = payment.getText().toString();

        //

        UserModel userModel = new UserModel();
        userModel.setName(name1);
        userModel.setUsername(username1);
        userModel.setPassword(password1);
        userModel.setCollege(college1);
        userModel.setMobile(mobile1);
        userModel.setEmail(email1);
        userModel.setPayment(payment1);

        try {
            DatabaseHandler d1 = DatabaseHandler.getInstance(MainActivity.this);
            d1.addUser(userModel);
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"Error", Toast.LENGTH_SHORT).show();
        }


    }
    /*public void signIn(View view)
    {
        try
        {
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "Hello CNT", Toast.LENGTH_SHORT).show();
        }
    }*/
    public void refresh(View view)
    {
        try
        {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(),"Hello CNT", Toast.LENGTH_SHORT).show();
        }
    }
}
