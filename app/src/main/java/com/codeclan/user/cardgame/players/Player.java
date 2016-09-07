package com.codeclan.user.cardgame.players;

import com.codeclan.user.cardgame.cards.*;
import java.util.*;

/**
 * Created by user on 06/09/2016.
 */
public abstract class Player {

    String name;
    ArrayList<Card> hand;

    public Player(){
        this.hand = new ArrayList<Card>();
    }

    public int handCount() {
        return hand.size();
    }

    public void handAdd(Card card) {
        hand.add(card);
    }

    public void handClear() {
        hand.clear();
    }

    public int handValue() {
        int total = 0;
        for (Card card : hand){
            total += card.getValue();
        }
        return total;
    }

    public String handPrint(){
        String statement = "";
        for (Card card : hand){
            statement = statement + card.print() + ", ";
        }
        Integer score = handValue();
        statement = statement + "totals " + score.toString();
        return statement;
    }

    public Card handRemove(Card card) {
        if (hand.remove(card)) {
            return card;
        }
        return null;
    }

    public Card handRemoveAtZero() {
        Card card = hand.remove(0);
        return null;
    }

    public Card firstCard() {
        return hand.get(0);
    }

}
