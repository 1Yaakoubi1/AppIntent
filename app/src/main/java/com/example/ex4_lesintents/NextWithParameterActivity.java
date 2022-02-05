package com.example.ex4_lesintents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NextWithParameterActivity extends AppCompatActivity {
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_with_parameter);
        tv1=findViewById(R.id.textViewTV1);
        Bundle extras=getIntent().getExtras();
        String n = extras.getString("TEXT");
        tv1.setText("le parametre passé est : "+n);
    }
}