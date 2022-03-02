package com.example.seiieinzelbeispiel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.database.Observable;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.seiieinzelbeispiel.matrikelnummer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Called when the user taps the "Abschicken" Button
    public void sendMatrikelnummer(View view) {
//        Intent intent = new Intent(this, DisplayMessageActivity.class);
        TextView textView = (TextView) findViewById(R.id.matrikelnummer_input);
        String matrikelnummer = textView.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, matrikelnummer);
//        startActivity(intent);

    }

}