package com.example.jackherrer.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class in_game extends AppCompatActivity {

    int lives = 7;
    String word = "abcabc";
    String answer = "";
    //StringBuilder update_answer = new StringBuilder(answer);



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
        if(answer_letters.length()==1) {
            char letter = answer_letters.charAt(0);

            for(int i = 0; i < word.length(); i++){
                if(word.charAt(i) == letter){

                    Toast.makeText(this,"Bingo " + letter, Toast.LENGTH_SHORT).show();

                    //http://stackoverflow.com/questions/6952363/replace-a-character-at-a-specific-index-in-a-string


                    char[] myNameChars = answer.toCharArray();
                    myNameChars[i] = letter;
                    answer = String.valueOf(myNameChars);


                    TextView answer_view = (TextView)findViewById(R.id.in_game_answer);
                    answer_view.setText(answer);

                   // update_answer.setCharAt(i, letter);

                    //String newName = word.substring(0,4)+'x'+word.substring(5);
                   // word.setCharAt(4, 'x');
                }
            }

        }

        // toast invalid input
        else{Toast.makeText(this,"invalid input", Toast.LENGTH_SHORT).show();}


    }
}
