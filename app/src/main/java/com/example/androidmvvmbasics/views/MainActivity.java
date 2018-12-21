package com.example.androidmvvmbasics.views;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.androidmvvmbasics.R;
import com.example.androidmvvmbasics.databinding.ActivityMainBinding;
import com.example.androidmvvmbasics.viewmodels.LoginViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("akt", "onCreate: ");
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(new LoginViewModel());
        activityMainBinding.executePendingBindings();
    }

    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        Log.d("akt", "runMe: msg: " + message);
        if (message != null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }

}
