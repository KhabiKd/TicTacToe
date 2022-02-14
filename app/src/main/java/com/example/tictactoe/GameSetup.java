package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GameSetup extends AppCompatActivity {

    private EditText player1;
    private EditText player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_setup);

        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);
    }

    public void startGameClick(View view){
        String player1Name = player1.getText().toString();
        String player2Name = player2.getText().toString();

        Intent intent = new Intent(this, GameDisplay.class);
        intent.putExtra("player1Name", player1Name);
        intent.putExtra("player2Name", player2Name);
        startActivity(intent);
    }
}