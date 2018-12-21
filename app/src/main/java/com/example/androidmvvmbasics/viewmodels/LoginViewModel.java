package com.example.androidmvvmbasics.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import com.example.androidmvvmbasics.BR;
import com.example.androidmvvmbasics.models.User;

public class LoginViewModel extends BaseObservable {

    private User user;

    private String successMessage = "Login was successful";
    private String errorMessage = "Email or Password not valid";

    @Bindable
    public String toastMessage = null;

    public String getToastMessage() {
        Log.d("akt", "getToastMessage: " + toastMessage);
        return toastMessage;
    }

    private void setToastMessage(String toastMessage) {
        Log.d("akt", "setToastMessage: " + toastMessage);
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    public LoginViewModel() {
        Log.d("akt", "LoginViewModel: ");
        user = new User("", "");
    }

    public void afterEmailTextChanged(CharSequence s) {
        Log.d("akt", "afterEmailTextChanged: " + s.toString());
        user.setEmail(s.toString());
    }

    public void afterPasswordTextChanged(CharSequence s) {
        Log.d("akt", "afterPasswordTextChanged: " + s.toString());
        user.setPassword(s.toString());
    }

    public void onLoginClicked() {
        Log.d("akt", "onLoginClicked: ");
        if (user.isInputDataValid())
            setToastMessage(successMessage);
        else
            setToastMessage(errorMessage);
    }

}
