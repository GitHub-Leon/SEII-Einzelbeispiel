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

import com.example.seiieinzelbeispiel.network.NetworkClient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Called when the user taps the "Abschicken" Button
    public void sendMatrikelnummer(View view) throws Exception{
        EditText matrikelnummerInput = (EditText) findViewById(R.id.matrikelnummer_input);
        TextView response_server_text = (TextView) findViewById(R.id.response_server);

        NetworkClient networkClient = new NetworkClient("se2-isys.aau.at", 53212, matrikelnummerInput.getText().toString(), response_server_text);
        networkClient.start();

    }

}

