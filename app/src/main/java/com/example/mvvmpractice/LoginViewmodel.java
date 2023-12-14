package com.example.mvvmpractice;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Arrays;
import java.util.List;


public class LoginViewmodel extends ViewModel {

    private MutableLiveData<Boolean> loginSuccess = new MutableLiveData<>();
    private MutableLiveData<String> toastMessage = new MutableLiveData<>();

    public LiveData<Boolean> getLoginSuccess() {
        return loginSuccess;
    }
    public LiveData<String> getToastMessage() {
        return toastMessage;
    }


    public void validateCredentials(String user,String pass) {
        // Simulate login validation
        String PASSWORD1 = "1234567890", PASSWORD2 = "0987654321" , PASSWORD3="1234509876";

        List<String> storedPasswords = Arrays.asList(PASSWORD1, PASSWORD2, PASSWORD3);
        if(user.length() !=10) {
            toastMessage.setValue("username contains exactly 10 numbers");
            return;
//            Toast.makeText(getToastMessage(, "username contains exactly 10 Numbers", Toast.LENGTH_SHORT).show();
//            return false;
        }
        // validation
        try{
            long data = Long.parseLong(user);
        }
        catch (NumberFormatException e){
            toastMessage.setValue("Username contains only Numbers");
            return ;
//
        }
        //password
        if(user.length() !=10) {
            toastMessage.setValue("Password contains exactly 10 Numbers");

        }

        try{
            long data = Long.parseLong(pass);
        }
        catch (NumberFormatException e){
            toastMessage.setValue("Enter only numbers in password");
            return;
//            Toast.makeText(view.getContext(), "Enter only numbers in password", Toast.LENGTH_SHORT).show();

        }
        if( !user.equals(pass)) {
            toastMessage.setValue("Username and password not match");
            return;
        }

        boolean isValid = storedPasswords.contains(pass);
        loginSuccess.setValue(isValid);
    }


}
