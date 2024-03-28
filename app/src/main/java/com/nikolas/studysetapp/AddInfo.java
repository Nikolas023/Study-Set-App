package com.nikolas.studysetapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class AddInfo extends AppCompatActivity {

    Button doneBtn;
    TextInputLayout termLayout;
    TextInputLayout defLayout;
    static String termText;
    static String defText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addinfoscreen);

        doneBtn = findViewById(R.id.doneButton);
        termLayout = findViewById(R.id.termLayout);
        defLayout = findViewById(R.id.definitionLayout);

        /*
        When the done button is clicked, it will check to see if the text or definition
        box is empty. If it is, nothing will be added to the ArrayList. If both have text,
        then it will add the information to the ArrayList.
        */
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                termText = termLayout.getEditText().getText().toString();
                defText = defLayout.getEditText().getText().toString();

                if(termText.equals("") || defText.equals("")) {
                    Toast.makeText(getApplicationContext(), "Must have a term with definition", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    MainActivity.addCard();
                    startActivity(intent);
                }
            }
        });
    }
}
