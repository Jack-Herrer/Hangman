package com.example.jackherrer.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class in_game extends AppCompatActivity {

    int lives = 7;
    //String word = "abcabc";
    String answer = "";
    String[] wordlist = {"allimentatie", "bergen", "vis"};

    //String[] array = getResources().getStringArray(R.array.animals_array);

    String word = wordlist[new Random().nextInt(wordlist.length)];




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
            answer+=".";

            TextView answer_view = (TextView)findViewById(R.id.in_game_answer);
            answer_view.setText(answer);

        }
    }

    public void on_in_game_enter(View view) {

        EditText answer_box = (EditText)findViewById(R.id.in_game_answer_box);
        String answer_letters = String.valueOf(answer_box.getText());

        //check for valid input
        if((answer_letters.length()==1) && (lives != 0) && (!answer.equals(word))) {
            char letter = answer_letters.charAt(0);

            boolean correct_letter = false;

            // check if letter is in word and update answer
            for(int i = 0; i < word.length(); i++){
                if(word.charAt(i) == letter){

                    Toast.makeText(this,"Bingo", Toast.LENGTH_SHORT).show();

                    char[] myNameChars = answer.toCharArray();
                    myNameChars[i] = letter;
                    answer = String.valueOf(myNameChars);

                    correct_letter = true;

                    // check on win
                    if(answer.equals(word)) {
                        Toast.makeText(this, "You win!", Toast.LENGTH_LONG).show();
                    }
                }
            }

            if (correct_letter){
                TextView answer_view = (TextView)findViewById(R.id.in_game_answer);
                answer_view.setText(answer);
            }

            //update lives in case of wrong letter
            else{
                lives--;
                TextView lives_view = (TextView)findViewById(R.id.in_game_lives);
                lives_view.setText("Score: " + lives);

                //check if lives left
                if(lives == 0){
                    Toast.makeText(this,"Game over: You lost", Toast.LENGTH_LONG).show();

                }
            }

        }

        // toast invalid input
        else if(lives == 0){
            Toast.makeText(this,"Game over: You lost", Toast.LENGTH_LONG).show();
        }

        else if(answer.equals(word)){
            Toast.makeText(this,"You win!", Toast.LENGTH_LONG).show();
        }

        else{Toast.makeText(this,"invalid input", Toast.LENGTH_SHORT).show();}


    }
}
