package com.codeclan.user.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.codeclan.user.cardgame.cards.*;
import com.codeclan.user.cardgame.game.*;
import com.codeclan.user.cardgame.players.*;

/**
 * Created by user on 05/09/2016.
 */
public class HighHand extends AppCompatActivity {

    Button mMenuButton;
    Button mPlayButton;
    TextView mPlayer1Score;
    TextView mPlayer2Score;
    TextView mWinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_hand);

        mMenuButton=(Button)findViewById(R.id.menu_button);
        mPlayButton=(Button)findViewById(R.id.play_button);
        mPlayer1Score=(TextView)findViewById(R.id.player_1_score);
        mPlayer2Score=(TextView)findViewById(R.id.player_2_score);
        mWinner=(TextView)findViewById(R.id.winner);

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
                Game game = new Game();
                User player1 = new User();
                Dealer player2 = new Dealer();
                game.initPlayers(player1, player2);
                game.initRound();
                game.dealOut();
                mPlayer1Score.setText(player1.handPrint());
                mPlayer2Score.setText(player2.handPrint());
            }
        });
    }
}
