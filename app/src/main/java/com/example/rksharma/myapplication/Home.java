package com.example.rksharma.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    Button scorner;
    Button pstudent;
    Button apply;
    Button feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        scorner = (Button) findViewById(R.id.b1);
        pstudent = (Button) findViewById(R.id.b2);
        feedback = (Button) findViewById(R.id.b3);
        apply = (Button) findViewById(R.id.b4);
    }
    public void show(View view)
    {
        try
        {
            Intent intent = new Intent(Home.this, User_list.class);
            startActivity(intent);
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(),"Hello CNT", Toast.LENGTH_SHORT).show();
        }
    }
}
