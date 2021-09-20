package com.yml.QueueCards;

public class Cards {
    private String suit;
    private String rank;

    Cards(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    Cards() {
        
    }

    @Override
    public String toString() {
        return rank+" of "+ suit;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
    public String getRank() {
        return rank;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }
}