package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GameDisplay extends AppCompatActivity {

    private final List<int[]> combinationsList = new ArrayList<>();

    private int[] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    private int playerTurn = 1;

    private int totalSelectedBoxes = 1;

    private LinearLayout playerOneLayout, playerTwoLayout;
    private ConstraintLayout constraintLayout;
    private TextView playerOneName, playerTwoName, winnerLable;
    private ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_display);

        playerOneName = findViewById(R.id.playerOne);
        playerTwoName = findViewById(R.id.playerTwo);

        playerOneLayout = findViewById(R.id.playerOneLayout);
        playerTwoLayout = findViewById(R.id.playerTwoLayout);
        constraintLayout = findViewById(R.id.constraintLayout);
        winnerLable = findViewById(R.id.winnerLable);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);

        combinationsList.add(new int[]{0, 1, 2});
        combinationsList.add(new int[]{3, 4, 5});
        combinationsList.add(new int[]{6, 7, 8});
        combinationsList.add(new int[]{0, 3, 6});
        combinationsList.add(new int[]{1, 4, 7});
        combinationsList.add(new int[]{2, 5, 8});
        combinationsList.add(new int[]{0, 4, 8});
        combinationsList.add(new int[]{2, 4, 6});

        final String getPlayerOneName = getIntent().getStringExtra("player1Name");
        final String getPlayerTwoName = getIntent().getStringExtra("player2Name");

        playerOneName.setText(getPlayerOneName);
        playerTwoName.setText(getPlayerTwoName);

        playerOneLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }
        });
        playerTwoLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }
        });

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(0)){
                    performAction((ImageView) view, 0);
                }
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(1)){
                    performAction((ImageView) view, 1);
                }
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(2)){
                    performAction((ImageView) view, 2);
                }
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(3)){
                    performAction((ImageView) view, 3);
                }
            }
        });
        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(4)){
                    performAction((ImageView) view, 4);
                }
            }
        });
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(5)){
                    performAction((ImageView) view, 5);
                }
            }
        });
        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(6)){
                    performAction((ImageView) view, 6);
                }
            }
        });
        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(7)){
                    performAction((ImageView) view, 7);
                }
            }
        });
        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(8)){
                    performAction((ImageView) view, 8);
                }
            }
        });
    }

    private void performAction(ImageView imageView, int selectedBoxPosition){

        boxPositions[selectedBoxPosition] = playerTurn;

        if(playerTurn == 1){
            imageView.setImageResource(R.drawable.cross);

            if(checkPlayerWin()){
                winnerLable.setText(playerOneName.getText().toString() + " Win!");
            }
            else if(totalSelectedBoxes==9){ winnerLable.setText("Draw!"); }
            else{
                changePlayerTurn(2);
                totalSelectedBoxes++;
            }
        }
        else{
            imageView.setImageResource(R.drawable.circle);

            if(checkPlayerWin()){
                winnerLable.setText(playerTwoName.getText().toString() + " Win!"); }
            else if(totalSelectedBoxes==9){ winnerLable.setText("Draw!"); }
            else{
                changePlayerTurn(1);
                totalSelectedBoxes++;
            }
        }
    }

    private void changePlayerTurn(int currentPlayerTurn){
        playerTurn = currentPlayerTurn;

        if(playerTurn == 1){
            playerOneLayout.setBackgroundResource(R.drawable.round_back_blue_white_border);
            playerTwoLayout.setBackgroundResource(R.drawable.round_back_blue);
        }
        else{
            playerTwoLayout.setBackgroundResource(R.drawable.round_back_blue_white_border);
            playerOneLayout.setBackgroundResource(R.drawable.round_back_blue);
        }
    }

    private boolean checkPlayerWin(){
        boolean response = false;

        for (int i=0; i<combinationsList.size(); i++){
            final int[] combination = combinationsList.get(i);

            if(boxPositions[combination[0]] == playerTurn && boxPositions[combination[1]] == playerTurn && boxPositions[combination[2]] == playerTurn){
                response = true;
            }
        }

        return response;
    }

    private boolean isBoxSelectable(int boxPosition){
        boolean response = false;

        if(boxPositions[boxPosition] == 0){
            response = true;
        }

        return response;
    }

    public void playAgainClick(View view){
        boxPositions = new int[]{0,0,0,0,0,0,0,0,0};
        playerTurn=1;
        totalSelectedBoxes=1;
        winnerLable.setText("");
        image1.setImageDrawable(null);
        image2.setImageDrawable(null);
        image3.setImageDrawable(null);
        image4.setImageDrawable(null);
        image5.setImageDrawable(null);
        image6.setImageDrawable(null);
        image7.setImageDrawable(null);
        image8.setImageDrawable(null);
        image9.setImageDrawable(null);

    }

    public void homeClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}