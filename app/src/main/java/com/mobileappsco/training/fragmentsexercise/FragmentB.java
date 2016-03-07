package com.mobileappsco.training.fragmentsexercise;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentB extends Fragment implements View.OnClickListener {

    EditText editTextB;
    Button buttonB;
    InterfaceB listenerB;
    View fragmentView;

    @Override
    public void onClick(View v) {
        String text = editTextB.getText().toString();
        Log.d("MYTAG", "FragmentB onClick() sending " + text);
        listenerB.sendTexttoA(text);
    }
    public interface InterfaceB {
        public void sendTexttoA(String text);
    }

    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listenerB = (InterfaceB) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement InterfaceA");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("MYTAG", "FragmentB onCreateView()");
        fragmentView = inflater.inflate(R.layout.fragment_b, container, false);
        editTextB = (EditText) fragmentView.findViewById(R.id.editTextB);
        buttonB = (Button) fragmentView.findViewById(R.id.buttonB);
        buttonB.setOnClickListener(this);
        // Inflate the layout for this fragment
        return fragmentView;
    }

}
