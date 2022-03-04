package com.example.seiieinzelbeispiel;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.seiieinzelbeispiel.network.NetworkClient;

public class MainActivity extends AppCompatActivity {
    EditText matrikelnummerInput;
    Button send_Button;
    TextView response_server_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send_Button = findViewById(R.id.send_button);
        matrikelnummerInput = findViewById(R.id.matrikelnummer_input);
        response_server_text = findViewById(R.id.response_server);

        send_Button.setOnClickListener(view -> {
            Thread networkClientThread = new Thread(new NetworkClient("se2-isys.aau.at", 53212, matrikelnummerInput.getText().toString(), response_server_text));
            networkClientThread.start();

        });
    }
}

