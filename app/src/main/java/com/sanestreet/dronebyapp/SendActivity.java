package com.sanestreet.dronebyapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.FrameLayout;

public class SendActivity extends AppCompatActivity implements ScannerFragment.OnFragmentInteractionListener {

    private FrameLayout fragmentContainer;
    private EditText textBarcode;
    private Button buttonOk, buttonScan;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        fragmentContainer = (FrameLayout) findViewById(R.id.fragmentContainer);
        textBarcode = (EditText) findViewById(R.id.textBarcode);
        buttonScan = (Button) findViewById(R.id.buttonScan);
        buttonOk = (Button) findViewById(R.id.buttonOk);

        buttonScan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String text = textBarcode.getText().toString();
                openFragment(text);
            }
        });
    }

    public void openFragment(String text){
        ScannerFragment fragment = ScannerFragment.newInstance(text);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);
        transaction.addToBackStack(null);
        transaction.add(R.id.fragmentContainer, fragment, "SCANNER_FRAGMENT").commit();
    }

    @Override
    public void onFragmentInteraction(String sendBackText) {
        textBarcode.setText(sendBackText);
        onBackPressed();
        onBackPressed();
        onBackPressed();
    }
}
