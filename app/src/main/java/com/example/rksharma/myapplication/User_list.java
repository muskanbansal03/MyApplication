package com.example.rksharma.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class User_list extends AppCompatActivity {

    TextView textView;
    //EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        textView = (TextView) findViewById(R.id.textView);
        //et1 = (EditText) findViewById(R.id.editText);



        try {
            DatabaseHandler mDatabaseHandler = DatabaseHandler.getInstance(User_list.this);

            List<UserModel> userModels = mDatabaseHandler.getAllUserProfile();
            String myData = "";
            String name="";
            String username="";
            String college="";
            String mobilenumber="";
            String email;
            String payment;

            String userData="";
            //int i=1;
            for (UserModel usermodel : userModels) {

                name = usermodel.getName();
                username = usermodel.getUsername();
                college = usermodel.getCollege();
                mobilenumber = usermodel.getMobile();
                email = usermodel.getEmail();
                payment = usermodel.getPayment();

                userData= name +"  "+ username +" "+ mobilenumber +"  "+ college +"  "+ email;
                int l = userData.length();


                while (l < 50) {
                    userData= userData+" ";
                    l++;
                }

                //i++;
                userData="--------------------------------------------------------------"+" "+userData;
                myData=myData+userData;


            }
            textView.setText(myData);


        }
        catch(Exception ex)
        {
            Toast.makeText(User_list.this, "error"+ex, Toast.LENGTH_SHORT).show();
        }




    }

}
