package com.cobanogluhasan.mvvmdatabindingexample.viewModel;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.cobanogluhasan.mvvmdatabindingexample.Interface.LoginResultCallbacks;
import com.cobanogluhasan.mvvmdatabindingexample.model.User;

public class LoginViewModel extends ViewModel {
    private User user;
    private LoginResultCallbacks loginResultCallbacks;

    public LoginViewModel(LoginResultCallbacks loginResultCallbacks) {
        this.loginResultCallbacks = loginResultCallbacks;
        this.user = new User();
    }


    //get the email from the view(Edittext) and set it to User
    public TextWatcher getEmailTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setEmail(s.toString());
            }
        };
    }

    //get the password from the view(Edittext) and set it to User
    public TextWatcher getPasswordTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setPassword(s.toString());
            }
        };
    }

    //login process
    public void onLoginClicked(View view) {
        int errorCode =user.isDataValid();

        if(errorCode==0) {
            loginResultCallbacks.onError("You must enter email and password!");
        }
        else if(errorCode==1) {
            loginResultCallbacks.onError("invalid email adress!");
        }
        else if(errorCode==2) {
        loginResultCallbacks.onError("password length must be longer than 6!");
        }
        else loginResultCallbacks.onSuccess("Login Successful!");

    }


}
