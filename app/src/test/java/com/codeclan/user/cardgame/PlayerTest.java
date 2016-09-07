package com.codeclan.user.cardgame;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.codeclan.user.cardgame.cards.*;
import com.codeclan.user.cardgame.players.*;

/**
 * Created by user on 06/09/2016.
 */
public class PlayerTest {

    User user;
    Card card;
    Card card2;

    @Before
    public void before(){
        user = new User();
        card = new Card(SuitType.DIAMONDS, RankType.THREE);
        card2 = new Card(SuitType.SPADES, RankType.FOUR);
    }

    @Test
    public void startsWithEmptyHand() {
        assertEquals(0, user.handCount());
    }

    @Test
    public void canAddCardToHand() {
        user.handAdd(card);
        assertEquals(1, user.handCount());
    }

    @Test
    public void canGetHandValueWithOneCard(){
        user.handAdd(card);
        assertEquals(3, user.handValue());
    }

    @Test
    public void canGetHandValueWithTwoCards(){
        user.handAdd(card);
        user.handAdd(card2);
        assertEquals(7, user.handValue());
    }

    @Test
    public void canPrintHand(){
        user.handAdd(card);
        user.handAdd(card2);
        assertEquals("three of diamonds, four of spades, ", user.handPrint());
    }

    @Test
    public void clearHand() {
        user.handAdd(card);
        assertEquals(1, user.handCount());
        user.handClear();
        assertEquals(0, user.handCount());
    }

    @Test
    public void canRemoveCardFromHand(){
        user.handAdd(card);
        assertEquals(1, user.handCount());
        user.handRemove(card);
        assertEquals(0, user.handCount());
    }

    @Test
    public void canRemoveCardFromHandBAtZero(){
        user.handAdd(card);
        user.handRemoveAtZero();
        assertEquals(0, user.handCount());
    }

    @Test
    public void canReturnCardOnRemove(){
        user.handAdd(card);
        Card returnedCard = user.handRemove(card);
        assertEquals(SuitType.DIAMONDS, returnedCard.getSuit());
    }

    @Test
    public void canReturnCardOnRemove2(){
        user.handAdd(card);
        Card returnedCard = user.firstCard();
        assertEquals(SuitType.DIAMONDS, returnedCard.getSuit());
    }
}
