package com.example.seiieinzelbeispiel.network;

import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class NetworkClient extends Thread {
    private String host;
    private int port;
    private String matrikelnummer;
    private String response;
    private TextView response_server_text;

    private DataOutputStream outToServer;
    private BufferedReader inFromServer;


    public NetworkClient(String host, int port, String matrikelnummer, TextView response_server_text) {
        this.host = host;
        this.port = port;
        this.matrikelnummer = matrikelnummer;
        this.response_server_text = response_server_text;
    }

    @Override
    public void run() {
        try {
            Socket clientSocket = new Socket(host, port);

            //create in- and outputstreams
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
            inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            //send matrikelnummer to server
            outToServer.writeBytes(matrikelnummer + '\n');

            //response from server
            response = inFromServer.readLine();
            response_server_text.append('\n' + response);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
