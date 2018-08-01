package re.poker.cards;

import re.poker.cards.deck.Card;

import java.util.Set;

public class Hand {

    private String playerName;
    private Set<Card> cards;

    public Hand(String playerName, Set<Card> cards) {
        if(cards.size() != 5)
            throw new IllegalArgumentException("An hand must contains 5 cards!");
        this.playerName = playerName;
        this.cards = cards;
    }


    public String getPlayerName() { return playerName; }
    public Set<Card> getCards() { return cards; }

}
