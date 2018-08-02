package re.poker;

import re.poker.cards.Hand;
import re.poker.cards.Card;

import java.util.*;
import java.util.stream.Collectors;

public class Game {

    private Map<String, Hand> hands = new HashMap<>();

    public void submit(String playerName, Hand hand) {
        if(! isLegit(hand))
            throw new IllegalArgumentException("The submitted hand is not legit!");
        this.hands.put(playerName, hand);
    }

    public Hand getByPlayer(String playerName) { return hands.get(playerName); }


    public String declareWinner() {
        throw new UnsupportedOperationException("Cannot determine winner!");
    }


    private boolean isLegit(Hand newHand) {
        Set<Card> played =
                hands.values().stream().map(Hand::getCards).flatMap(Set::stream).collect(Collectors.toSet());
        Set<Card> intersection = new HashSet<>(newHand.getCards());
        intersection.retainAll(played);
        return intersection.isEmpty();
    }


}
