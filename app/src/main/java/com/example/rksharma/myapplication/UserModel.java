package com.example.rksharma.myapplication;

/**
 * Created by R K Sharma on 18-10-2016.
 */

public class UserModel {

    private String name;
    private String username;
    private String password;
    private String college;
    private String mobile;
    private String email;
    private String payment;

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getCollege()
    {
        return college;
    }
    public void setCollege(String college)
    {
        this.college = college;
    }

    public String getMobile()
    {
        return mobile;
    }
    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPayment() { return payment; }
    public void setPayment(String payment) { this.payment = payment; }


}
