package com.nikolas.studysetapp;

import static com.nikolas.studysetapp.MainActivity.cards;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CardInfo extends AppCompatActivity {

    TextView term;
    TextView definition;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.termclickscreen);

        term = findViewById(R.id.term);
        definition = findViewById(R.id.definition);

        Bundle bundle = getIntent().getExtras();
        int stuff = bundle.getInt("position");
        term.setText(cards.get(stuff).getTerm());
        definition.setText(cards.get(stuff).getDefinition());

    }
}
