package com.example.seii;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText input;
    TextView textTop;
    TextView textBottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        button.setText("Los!");

        input = (EditText)findViewById(R.id.editText);

        textTop = (TextView)findViewById(R.id.textView);
        textTop.setText("Matrikelnummer");

        textBottom = (TextView)findViewById(R.id.textView2);
        textBottom.setText("...");




    }
}
