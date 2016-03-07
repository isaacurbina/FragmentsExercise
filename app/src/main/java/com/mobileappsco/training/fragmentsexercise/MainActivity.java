package com.mobileappsco.training.fragmentsexercise;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Configuration;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentA.InterfaceA, FragmentB.InterfaceB
{

    Fragment fA;
    Fragment fB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fA = (FragmentA) getFragmentManager().findFragmentById(R.id.fragmentA);
        fB = (FragmentB) getFragmentManager().findFragmentById(R.id.fragmentB);
    }

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    @Override
    public void sendTexttoB(String text) {
        Log.d("MYTAG", "MainActivity sendTexttoB() sending " + text);
        TextView textView = (TextView) fB.getActivity().findViewById(R.id.editTextB);
        textView.setText(text);
    }

    @Override
    public void sendTexttoA(String text) {
        Log.d("MYTAG", "MainActivity sendTexttoA() sending " + text);
        TextView textView = (TextView) fA.getActivity().findViewById(R.id.editTextA);
        textView.setText(text);
    }

}
