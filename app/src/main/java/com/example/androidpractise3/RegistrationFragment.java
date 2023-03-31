package com.example.androidpractise3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;


public class RegistrationFragment extends Fragment {
    final public static String TAG = RegistrationFragment.class.getSimpleName();

    public RegistrationFragment(){

    }

    public static RegistrationFragment newInstance(){
        return new RegistrationFragment();
    }

    TextInputEditText name;
    TextInputEditText surname;
    TextInputEditText email;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        Toast.makeText(getContext(), "onCreateView", Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.activity_registration, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
       name = (TextInputEditText) view.findViewById(R.id.Name);
       surname = (TextInputEditText) view.findViewById(R.id.surname);
       email = (TextInputEditText) view.findViewById(R.id.email);

       Button submitButton = (Button) view.findViewById(R.id.submit_button);

       submitButton.setOnClickListener(vie -> {
           Bundle userData = new Bundle();
           userData.putString("name", name.getText().toString());
           userData.putString("surname", surname.getText().toString());
           userData.putString("email", email.getText().toString());

           ProfileFragment profileFragment = ProfileFragment.newInstance();
           profileFragment.setArguments(userData);
           requireActivity().getSupportFragmentManager().beginTransaction()
                   .replace(R.id.fragment_container_view, ProfileFragment)
                   .addToBackStack(TAG)
                   .commit();

           Log.i(TAG, "Data transferred");
       });
       Log.i(TAG, "onViewCreated");
       Toast.makeText(getContext(), "onViewCreated", Toast.LENGTH_SHORT).show();
    }

}