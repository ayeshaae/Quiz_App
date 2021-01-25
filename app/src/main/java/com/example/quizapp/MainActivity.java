package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etName = (EditText) findViewById(R.id.etName);
        Button btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etName.getText().toString().trim().equalsIgnoreCase("")) {
                    etName.setError("YOU MUST ENTER YOUR NAME..");
                } else {
                    startActivity(new Intent(MainActivity.this, questions.class));
                    Intent i = new Intent(MainActivity.this, questions.class);
                    String st = etName.getText().toString();
                    i.putExtra("Value", st);
                    startActivity(i);
                    finish();
                }
            }
        });

    }

}
