package com.cobanogluhasan.mvvmdatabindingexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.cobanogluhasan.mvvmdatabindingexample.Interface.LoginResultCallbacks;
import com.cobanogluhasan.mvvmdatabindingexample.viewModel.LoginViewModel;
import com.cobanogluhasan.mvvmdatabindingexample.viewModel.LoginViewModelFactory;
import com.cobanogluhasan.mvvmdatabindingexample.databinding.ActivityMainBinding;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements LoginResultCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(ViewModelProviders.of(
                this,
                new LoginViewModelFactory(this))
                .get(LoginViewModel.class));
    }

    @Override
    public void onSuccess(String message) {
        Toasty.success(this, message,Toasty.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String message) {
        Toasty.error(this, message,Toasty.LENGTH_SHORT).show();
    }
}