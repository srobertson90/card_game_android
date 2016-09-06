package com.codeclan.user.cardgame;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.codeclan.user.cardgame.cards.*;


/**
 * Created by user on 06/09/2016.
 */
public class CardTest {

    Card card;

    @Before
    public void before(){
        card = new Card(SuitType.HEARTS, RankType.TWO);
    }

    @Test
    public void canGetSuit(){
        assertEquals(SuitType.HEARTS, card.getSuit());
    }

    @Test
    public void canGetRank(){
        assertEquals(RankType.TWO, card.getRank());
    }

    @Test
    public void canGetValue(){
        assertEquals(2, card.getValue());
    }
}

