package com.example.seii;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText inputField;
    TextView textTop;
    TextView textBottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        button.setText("Los!");

        inputField = (EditText)findViewById(R.id.editText);

        textTop = (TextView)findViewById(R.id.textView);
        textTop.setText("Matrikelnummer");

        textBottom = (TextView)findViewById(R.id.textView2);
        textBottom.setText("...");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = inputField.getText().toString();

                Connection connection = new Connection(input);
                AsyncTask task = connection.execute();

                try {
                    Object waitTask = task.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

                textBottom.setText(connection.getOutput());
            }
        });

    }
}
