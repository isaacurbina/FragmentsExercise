package com.mobileappsco.training.fragmentsexercise;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentA extends Fragment implements View.OnClickListener {

    EditText editTextA;
    Button buttonA;
    InterfaceA listenerA;
    View fragmentView;

    @Override
    public void onClick(View v) {
        String text = editTextA.getText().toString();
        Log.d("MYTAG", "FragmentA onClick() sending "+text);
        listenerA.sendTexttoB(text);
    }

    public interface InterfaceA {
        public void sendTexttoB(String text);
    }

    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listenerA = (InterfaceA) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement InterfaceA");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("MYTAG", "FragmentA onCreateView()");
        fragmentView = inflater.inflate(R.layout.fragment_a, container, false);
        editTextA = (EditText) fragmentView.findViewById(R.id.editTextA);
        buttonA = (Button) fragmentView.findViewById(R.id.buttonA);
        buttonA.setOnClickListener(this);
        return fragmentView;
    }

}
