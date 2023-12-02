package com.example.explicite2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        final String textToModify = intent.getStringExtra("textToModify");

        Button uppercaseButton = findViewById(R.id.uppercaseButton);
        uppercaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String modifiedResult = textToModify.toUpperCase();
                sendResult(modifiedResult);
            }
        });

        Button reverseButton = findViewById(R.id.reverseButton);
        reverseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String modifiedResult = new StringBuilder(textToModify).reverse().toString();
                sendResult(modifiedResult);
            }
        });
    }

    private void sendResult(String modifiedResult) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("modifiedResult", modifiedResult);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
