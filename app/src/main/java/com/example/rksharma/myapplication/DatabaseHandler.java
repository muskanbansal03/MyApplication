package com.example.rksharma.myapplication;
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;  //Package for database connectivity

import android.util.Log;
import android.widget.Toast;

import static android.widget.Toast.*;/**
 * Created by R K Sharma on 18-10-2016.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    //Database Version
    private static final int DATABASE_VERSION = 1;

    //Database instance
    private static DatabaseHandler mDatabaseHandlerInstance;

    //Database name
    private static final String DATABASE_NAME = "CnT.sqlite";

    //Registration List Table name
    private static final String table_name = "UserList";

    //Fields name for registration table

    private static final String key_id = "student_id";
    private static final String key_name = "student_name";
    private static final String key_username = "student_username";
    private static final String key_password = "password";
    private static final String key_college = "college";
    private static final String key_mobile = "mobile_no";
    private static final String key_email = "email";
    private static final String key_payment = "payment";

    //method checks if the table is created or not

    public static DatabaseHandler getInstance(Context context)
    {
        if(mDatabaseHandlerInstance == null)
        {
            mDatabaseHandlerInstance = new DatabaseHandler(context.getApplicationContext());
        }
        return mDatabaseHandlerInstance;
    }

    //constructor

    public DatabaseHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    //for creating fields of the table

    public void onCreate(SQLiteDatabase db)
    {
        try
        {
            String create_table_name = "CREATE TABLE "+ table_name +"("+
                    key_id +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+
                    key_name +"TEXT,"+
                    key_username +"TEXT,"+
                    key_password +"TEXT,"+
                    key_college +"TEXT,"+
                    key_mobile +"TEXT,"+
                    key_email +"TEXT,"+
                    key_payment +"TEXT )";

            db = this.getWritableDatabase();
            db.execSQL(create_table_name);
             //to take current instance of database
            Log.d("Hello", "Table Created");
            //Toast.makeText(, "Table created", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
          Log.d("Error", "Error"+ e);
        }
    }

    //method for adding users
    public void addUser(UserModel mUserModel)
    {
        //class used to add values

        ContentValues values = new ContentValues();
        values.put(key_name, mUserModel.getName());
        values.put(key_username, mUserModel.getUsername());
        values.put(key_password, mUserModel.getPassword());
        values.put(key_college, mUserModel.getCollege());
        values.put(key_mobile, mUserModel.getMobile());
        values.put(key_email, mUserModel.getEmail());
        //values.put(key_payment, mUserModel.getPayment());

        //getwritabledatabase() put database in writable form
        //to insert a row

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(table_name, null, values);

        //close the database connection
        db.close();
    }

    //to retrieve from table

    public ArrayList<UserModel>  getAllUserProfile() {

        ArrayList<UserModel> userModelArrayList = null;
        try {
            String selectQuery = "SELECT  * FROM " + table_name;
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {
                userModelArrayList = new ArrayList<UserModel>();
                do {

                    UserModel userModel = new UserModel();
                    // 	get  the  data into array,or class variable
                    userModel.setName(cursor.getString(1));
                    userModel.setUsername(cursor.getString(2));
                    userModel.setCollege(cursor.getString(4));
                    userModel.setMobile(cursor.getString(5));
                    userModel.setPassword(cursor.getString(3));
                    userModel.setEmail(cursor.getString(6));
                    //userModel.setPayment(cursor.getString(7));


                    userModelArrayList.add(userModel);
                } while (cursor.moveToNext());
            }
            db.close();
        } catch (Exception ex) {
            Log.d("hello", "Value: " + ex);
        }
        return userModelArrayList;
    }

    //to check if user exists
    public boolean checkUser(String username, String pass)
    {
        Boolean Status = false;
        try
        {
            String check = "SELECT "+ key_password +" FROM "+ table_name +" WHERE "+ key_username  +"= '"+ username+"'";
            Log.d("ERROR", "ERROR"+ check);

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(check, null);
            String password="";
            if (cursor.moveToFirst())
                do {
                    password=cursor.getString(0);

                } while (cursor.moveToNext());

            if(password.equals(pass))
                Status = true;
            else
                Status = false;
        }
        catch (Exception e)
        {

        }
        return Status;
    }

    public boolean paymentUser(String username)
    {
        Boolean Status = false;
        try
        {
            String check = "SELECT "+ key_payment +" FROM "+ table_name +" WHERE "+ key_username  +"= '"+ username+"'";
            Log.d("ERROR", "ERROR"+ check);

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(check, null);
            String payment = "";
            String pay = "Yes";
            String pay1 = "YES";
            String pay2 = "yes";
            if (cursor.moveToFirst())
                do {
                    payment=cursor.getString(0);

                } while (cursor.moveToNext());

            if(payment.equals(pay) || payment.equals(pay1) || payment.equals(pay2))
                Status = true;
            else
                Status = false;
        }
        catch (Exception e)
        {

        }
        return Status;
    }

    //to drop table
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {//drops older table if exists
        try
        {
            db.execSQL("DROP TABLE IF EXISTS"+ table_name);
            onCreate(db);
        }
        catch(Exception e)
        {
            Log.d("value", "value"+ e);
        }
    }
}
