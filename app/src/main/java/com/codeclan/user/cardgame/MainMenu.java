package com.codeclan.user.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/**
 * Created by user on 05/09/2016.
 */
public class MainMenu extends AppCompatActivity{

    Button mHighHandButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHighHandButton=(Button)findViewById(R.id.high_hand_button);

        mHighHandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, HighHand.class);
                startActivity(intent);
            }
        });
    }
}
