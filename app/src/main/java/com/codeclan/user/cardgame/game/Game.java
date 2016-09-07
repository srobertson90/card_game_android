package com.codeclan.user.cardgame.game;

import com.codeclan.user.cardgame.cards.*;
import com.codeclan.user.cardgame.players.*;
import java.util.*;

/**
 * Created by user on 06/09/2016.
 */
public class Game {

    ArrayList<Player> players;
    ArrayList<Card> deck;

    public Game(){
        this.players = new ArrayList<Player>();
        this.deck = new ArrayList<Card>();
    }

    public int deckSize(){
        return deck.size();
    }

    public void addToDeck(Card card){
        deck.add(card);
    }

    public void addToPlayers(Player player){
        players.add(player);
    }

    public void fullDeck(){
        for(SuitType suit : SuitType.values()){
            for(RankType rank : RankType.values()){
                deck.add(new Card(suit, rank));
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(this.deck);
    }

    public void clearDeck(){
        deck.clear();
    }

    public void clearPlayers(){
        players.clear();
    }

    public Card removeFromDeck(){
        if (deck.get(0) != null) {
            Card card = deck.remove(0);
            return card;
        }
        return null;
    }

    public void dealCard(Player player){
        Card card = removeFromDeck();
        player.handAdd(card);
    }

    public void dealOut(){
        for(int i=0; i<2; i++){
            for (Player player : players){
                dealCard(player);
            }
        }
    }

    public void initDeck(){
        clearDeck();
        fullDeck();
        shuffleDeck();
    }

    public void initPlayers(User player1, Dealer player2){
        clearPlayers();
        addToPlayers(player1);
        addToPlayers(player2);
    }

    public void initRound(){
        for (Player player : players){
            player.handClear();
        }
        initDeck();
    }

}
