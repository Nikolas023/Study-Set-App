package com.nikolas.studysetapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CardAdapter.MyClickInterface{

    Button addBtn;
    RecyclerView recyclerView;
    static ArrayList<Card> cards = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBtn = findViewById(R.id.addCardButton);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddInfo.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.recycler_view);
        CardAdapter adapter = new CardAdapter(cards, this, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }


    //When a card is clicked it will transition to the term click screen.
    @Override
    public void onItemClick(int positionOfTheCard) {
        Intent intent = new Intent(this, CardInfo.class);
        Bundle bundle = new Bundle();
        bundle.putInt("position", positionOfTheCard);
        intent.putExtras(bundle);
        startActivity(intent);
    }


    public static void addCard() {
        cards.add(new Card(AddInfo.termText, AddInfo.defText));
    }
}