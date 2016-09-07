package com.codeclan.user.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.codeclan.user.cardgame.game.*;
import com.codeclan.user.cardgame.players.*;

/**
 * Created by user on 05/09/2016.
 */
public class HighHand extends AppCompatActivity {

    Button mMenuButton;
    Button mPlayButton;
    TextView mPlayer1Hand;
    TextView mPlayer1Score;
    TextView mPlayer2Hand;
    TextView mPlayer2Score;
    TextView mWinner;
    Game mGame;
    User mPlayer1;
    Dealer mPlayer2;

    public void showResults(){
        mPlayer1Hand.setText("player 1: " + mPlayer1.handPrint());
        mPlayer1Score.setText(mPlayer1.handPrintScore());
        mPlayer2Hand.setText("player 2: " + mPlayer2.handPrint());
        mPlayer2Score.setText(mPlayer2.handPrintScore());
        if (mPlayer1.handValue() > mPlayer2.handValue()){
            mWinner.setText("Player 1 wins!");
        }
        else if (mPlayer1.handValue() < mPlayer2.handValue()){
            mWinner.setText("Player 2 wins!");
        }
        else {
            mWinner.setText("Draw!");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_hand);

        mMenuButton=(Button)findViewById(R.id.menu_button);
        mPlayButton=(Button)findViewById(R.id.play_button);
        mPlayer1Hand=(TextView)findViewById(R.id.player_1_hand);
        mPlayer1Score=(TextView)findViewById(R.id.player_1_score);
        mPlayer2Hand=(TextView)findViewById(R.id.player_2_hand);
        mPlayer2Score=(TextView)findViewById(R.id.player_2_score);
        mWinner=(TextView)findViewById(R.id.winner);

        mGame = new Game();
        mPlayer1 = new User();
        mPlayer2 = new Dealer();
        mGame.initPlayers(mPlayer1, mPlayer2);
        mGame.run();
        showResults();

        mMenuButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(HighHand.this, MainMenu.class);
                startActivity(intent);
            }
        });

        mPlayButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mGame.run();
                showResults();
            }
        });
    }
}
