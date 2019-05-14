package com.sanestreet.dronebyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SampleInfoActivity extends AppCompatActivity {

    private TextView info1;
    private Button btnAccept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_info);

        info1 = (TextView)findViewById(R.id.info1);
        btnAccept = (Button)findViewById(R.id.button_accept);


        Intent intent = getIntent();
        final String data = intent.getStringExtra("data");
        info1.setText(data);

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SampleInfoActivity.this,"Package '"+getIntent().getStringExtra("data")+"' ready for takeoff", Toast.LENGTH_LONG).show();
            }
        });

    }
}
