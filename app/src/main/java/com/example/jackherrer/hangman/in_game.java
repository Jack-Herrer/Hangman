package com.example.jackherrer.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    public void on_in_game_enter(View view) {

        EditText answer = (EditText)findViewById(R.id.in_game_answer_box);
        String answer_letters = String.valueOf(answer.getText());

        //check for valid input
        if(answer_letters.length()==1) {
            char letter = answer_letters.charAt(0);
        }

        // toast invalid input
        else{Toast.makeText(this,"invalid input", Toast.LENGTH_SHORT).show();}


    }
}
