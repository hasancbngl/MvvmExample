package com.cobanogluhasan.mvvmdatabindingexample.model;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;

public class User extends BaseObservable {
    //data binding nonnull means email and password can not be null
    @NonNull
    private String email,password;

    public User() {}

    public User(@NonNull String email,@NonNull String password) {
        this.email = email;
        this.password = password;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }
    @NonNull
    public String getEmail() {
        return email;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public int isDataValid() {
        //return the data if the email match and password more than 6 char
        if(TextUtils.isEmpty(getEmail()))
            return 0;
        else if(!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 1;
        else if(getPassword().length()<6)
            return 2;
        else
        return -1;
    }

}

