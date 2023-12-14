 package com.example.mvvmpractice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

 public class LoginFragment extends Fragment {

     private EditText passwordEditText, username;
     private Button loginButton;
     private LoginViewmodel loginViewModel;

     @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         return inflater.inflate(R.layout.fragment_login, container, false);
     }

     @Override
     public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
         super.onViewCreated(view, savedInstanceState);
        username = view.findViewById(R.id.username);
         passwordEditText = view.findViewById(R.id.password);
         loginButton = view.findViewById(R.id.login);


         loginViewModel = new ViewModelProvider(this).get(LoginViewmodel.class);
         loginViewModel.getToastMessage().observe(getActivity(), message -> {
             if (message != null) {
                 Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
             }
         });


         loginButton.setOnClickListener(v -> {
             String password = passwordEditText.getText().toString();
             String user = username.getText().toString();
             loginViewModel.validateCredentials(user,password);



         });

         observeLoginResult();
     }


     private void observeLoginResult() {
         loginViewModel.getLoginSuccess().observe(getViewLifecycleOwner(), success -> {
             if (success) {
                 // Navigate to the data fragment
                 requireActivity().getSupportFragmentManager()
                         .beginTransaction()
                         .replace(R.id.frameLayout, new recyclerFragment())
                         .addToBackStack(null)
                         .commit();
                 Toast.makeText(getActivity(), "successful", Toast.LENGTH_SHORT).show();
             } else {
                 // Display login failure message
                 // Toast.makeText(requireContext(), "Invalid password", Toast.LENGTH_SHORT).show();
             }
         });
     }
 }
