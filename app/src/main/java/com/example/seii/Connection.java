package com.example.seii;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connection extends AsyncTask {

    String input;
    String modifiedSentence;

    public Connection(String input){
        this.input = input;
    }


    @Override
    protected Object doInBackground(Object[] objects) {

        try {

            Socket clientSocket = new Socket("se2-isys.aau.at", 53212);

            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            input = inFromUser.readLine();

            outToServer.writeBytes(input + '\n');

            modifiedSentence = inFromServer.readLine();

            clientSocket.close();


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return modifiedSentence;
    }

    public String getOutput(){
        return modifiedSentence;
    }

}
