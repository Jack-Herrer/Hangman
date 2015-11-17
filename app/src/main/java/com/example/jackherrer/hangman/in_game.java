package com.example.jackherrer.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class in_game extends AppCompatActivity {

    int lives = 7;
    String word = "allimentatie";
    String answer = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);

        TextView lives_view = (TextView)findViewById(R.id.in_game_lives);
        lives_view.setText("Score: " + lives);

        initiate_blank_spaces();


    }

    public void initiate_blank_spaces(){
        for(int i = 0; i < word.length(); i++){
            answer+=" -";

            TextView answer_view = (TextView)findViewById(R.id.in_game_answer);
            answer_view.setText(answer);
        }
    }
}
