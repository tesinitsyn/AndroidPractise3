package com.example.androidpractise3;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;


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
       name = view.findViewById(R.id.Name);
       surname = view.findViewById(R.id.surname);
       email = view.findViewById(R.id.email);

       Button submitButton = view.findViewById(R.id.submit_button);

       submitButton.setOnClickListener(vie -> {
           Bundle userData = new Bundle();
           userData.putString("name", Objects.requireNonNull(name.getText()).toString());
           userData.putString("surname", Objects.requireNonNull(surname.getText()).toString());
           userData.putString("email", Objects.requireNonNull(email.getText()).toString());

           ProfileFragment profileFragment = ProfileFragment.newInstance();
           profileFragment.setArguments(userData);
           requireActivity().getSupportFragmentManager().beginTransaction()
                   .replace(R.id.fragment_container_view, profileFragment)
                   .addToBackStack(TAG)
                   .commit();

           Log.i(TAG, "Data transferred");
       });
       Log.i(TAG, "onViewCreated");
       Toast.makeText(getContext(), "onViewCreated", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.i(TAG, "onViewStateRestored");
        Toast.makeText(getContext(), "onViewStateRestored", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i(TAG, "Attached");
        Toast.makeText(getContext(), "Attached", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Created");
        Toast.makeText(getContext(), "Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();

        if(getArguments() != null){
            Bundle dataFromSecond = getArguments();
            name.setText(dataFromSecond.get("name").toString());
            surname.setText(dataFromSecond.get("surname").toString());
            email.setText(dataFromSecond.get("email").toString());
        }

        Log.i(TAG, "onResume");
        Toast.makeText(getContext(), "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "Started");
        Toast.makeText(getContext(), "Started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView");
        Toast.makeText(getContext(), "onDestroyView", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "Paused");
        Toast.makeText(getContext(), "Paused", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "Stopped");
        Toast.makeText(getContext(), "Stopped", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
        Toast.makeText(getContext(), "onSaveInstanceState", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Destroyed");
        Toast.makeText(getContext(), "Destroyed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach");
        Toast.makeText(getContext(), "onDetach", Toast.LENGTH_SHORT).show();
    }
}