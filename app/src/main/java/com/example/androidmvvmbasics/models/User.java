package com.example.androidmvvmbasics.models;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Patterns;

public class User {

    @NonNull
    private String mEmail;

    @NonNull
    private String mPassword;


    public User(@NonNull final String email, @NonNull final String password) {
        this.mEmail = email;
        this.mPassword = password;
    }

    @NonNull
    public String getEmail() {
        return mEmail;
    }

    public void setEmail(@NonNull final String email) {
        this.mEmail = email;
    }

    @NonNull
    public String getPassword() {
        return mPassword;
    }

    public void setPassword(@NonNull final String password) {
        this.mPassword = password;
    }


    public boolean isInputDataValid() {
        return !TextUtils.isEmpty(getEmail()) &&
                Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches() &&
                getPassword().length() > 5;
    }

}
