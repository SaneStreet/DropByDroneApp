package com.sanestreet.dronebyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button buttonSend;
        //Button buttonModtag;
        //sendActivity();

        Button buttonRerollSend = findViewById(R.id.buttonSend);
        buttonRerollSend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent("com.sanestreet.dronebyapp.SendActivity"));
            }
        });

    }

    /*public void sendActivity(){
        Button buttonSend = findViewById(R.id.buttonRerollSend);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent("com.sanestreet.dronebyapp.SendActivity"));
            }
        });
    }*/

}
