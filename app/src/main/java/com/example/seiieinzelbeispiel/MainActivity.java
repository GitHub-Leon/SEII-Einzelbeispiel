package com.example.seiieinzelbeispiel;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.seiieinzelbeispiel.network.NetworkClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    Button send_Button;
    Button berechne_Button;
    EditText matrikelnummerInput;
    TextView response_server_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send_Button = findViewById(R.id.send_button);
        berechne_Button = findViewById(R.id.berechne_button);
        matrikelnummerInput = findViewById(R.id.matrikelnummer_input);
        response_server_text = findViewById(R.id.response_server);

        send_Button.setOnClickListener(view -> {
            Thread networkClientThread = new Thread(new NetworkClient("se2-isys.aau.at", 53212, matrikelnummerInput.getText().toString(), response_server_text));
            networkClientThread.start();

        });

        berechne_Button.setOnClickListener(view -> {
            ArrayList<Character> result = new ArrayList<>();
            for (char c : matrikelnummerInput.getText().toString().toCharArray()) {
                if (!isPrime(c)) {
                    result.add(c);
                }
            }

            Collections.sort(result);
            String resultString = TextUtils.join("", result); //create one string out of the result array list
            response_server_text.setText(resultString);
        });
    }

    private boolean isPrime(char c) {
        if (Character.getNumericValue(c) == 1) return false;
        for (int i = 2; i < Character.getNumericValue(c); i++) {
            if (Character.getNumericValue(c) % i == 0) {
                return false;
            }
        }
        return true;
    }
}

