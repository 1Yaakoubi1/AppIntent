package com.example.ex4_lesintents;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.pass);
        ((Button)findViewById(R.id.btIntExpli)).setOnClickListener(this);
        ((Button)findViewById(R.id.btIntExpliAvecDTA)).setOnClickListener(this);
        ((Button)findViewById(R.id.btGoogle)).setOnClickListener(this);
        ((Button)findViewById(R.id.btParam)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnAppelTele)).setOnClickListener(this);
        ((Button)findViewById(R.id.btnEmail)).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btIntExpli:
                intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
                break;
            case R.id.btIntExpliAvecDTA:
                intent = new Intent(MainActivity.this,NextWithParameterActivity.class);
                intent.putExtra("TEXT",editText.getText().toString());
                startActivity(intent);
                break;
            case R.id.btGoogle:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                startActivity(intent);
                break;
            case R.id.btParam:
                intent = new Intent(Settings.ACTION_APPLICATION_SETTINGS);
                startActivity(intent);
                break;
            case R.id.btnAppelTele:
                intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel: "+editText.getText()));
                startActivity(intent);
                break;
            case R.id.btnEmail :
                intent=new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"admin@gmail.com ","technicien@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT,"Réclamation Client");
                intent.putExtra(Intent.EXTRA_TEXT,"Réclamation Client concernant la clé 3G");
                startActivity(Intent.createChooser(intent,"send"));
            default:break;
        }

    }
}