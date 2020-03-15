package com.example.seii;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Connection extends AsyncTask {

    String input;
    String modifiedSentence;

    Socket clientSocket;
    BufferedReader inFromServer;
    DataOutputStream outToServer;


    public Connection(String input){
        this.input = input;
    }


    @Override
    protected Object doInBackground(Object[] objects) {

        try {

            clientSocket = new Socket("se2-isys.aau.at", 53212);

            outToServer = new DataOutputStream(clientSocket.getOutputStream());

            inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            outToServer.writeBytes(input + "\n");

            modifiedSentence = inFromServer.readLine();

            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return modifiedSentence;
    }

    public String getOutput(){
        return modifiedSentence;
    }

}
