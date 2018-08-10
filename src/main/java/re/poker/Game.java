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
        if (hands.isEmpty())
            return "No winner if no players!";
        return winnerByHC().getKey();
    }

    public Map.Entry<String, Hand> winnerByHC() {
        Card max = hands.values().stream()
                    .map(Hand::getCards).flatMap(Set::stream).max(Card::compareTo).get();
        return hands.entrySet().stream()
                .filter(e -> e.getValue().getCards().contains(max))
                .findFirst().get();
    }


    private boolean isLegit(Hand newHand) {
        Set<Card> played =
                hands.values().stream().map(Hand::getCards).flatMap(Set::stream).collect(Collectors.toSet());
        Set<Card> intersection = new HashSet<>(newHand.getCards());
        intersection.retainAll(played);
        return intersection.isEmpty();
    }


}
