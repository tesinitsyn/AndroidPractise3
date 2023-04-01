package com.example.androidpractise3;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class ProfileFragment extends Fragment {
    final public static String TAG = ProfileFragment.class.getSimpleName();

    public ProfileFragment() {

    }

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        Toast.makeText(getContext(), "onCreateView", Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.activity_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView nameView = view.findViewById(R.id.sporstmanName);
        TextView surnameView = view.findViewById(R.id.sporstmanSurname);
        TextView emailView = view.findViewById(R.id.sportmanEmail);

        if (getArguments() != null) {
            Bundle bundle = getArguments();
            nameView.setText(bundle.get("name").toString());
            surnameView.setText(bundle.get("surname").toString());
            emailView.setText(bundle.get("email").toString());
            Log.i(TAG, "Data Received");
        }

        Button returnButton = view.findViewById(R.id.return_button);
        returnButton.setOnClickListener(vie -> {
            Bundle backTransferData = new Bundle();
            backTransferData.putString("name", nameView.getText().toString() + "go back");
            backTransferData.putString("surname", surnameView.getText().toString());
            backTransferData.putString("email", emailView.getText().toString());
            RegistrationFragment registrationFragment = (RegistrationFragment) requireActivity()
                    .getSupportFragmentManager()
                    .findFragmentByTag(RegistrationFragment.TAG);
            if (registrationFragment != null) {
                System.out.println("if worked");
                registrationFragment.setArguments(backTransferData);
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_view, registrationFragment)
                        .commit();
            }
            Log.i(TAG, "button pressed");
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Created");
        Toast.makeText(getContext(), "Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "Started");
        Toast.makeText(getContext(), "Started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "Paused");
        Toast.makeText(getContext(), "Paused", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach");
        Toast.makeText(getContext(), "onAttach", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach");
        Toast.makeText(getContext(), "onDetach", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "Stopped");
        Toast.makeText(getContext(), "Stopped", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Destroyed");
        Toast.makeText(getContext(), "Destroyed", Toast.LENGTH_SHORT).show();
    }


}