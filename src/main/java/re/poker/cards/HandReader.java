package re.poker.cards;

import re.poker.cards.deck.Card;
import re.poker.cards.deck.CardValue;
import re.poker.cards.deck.Suit;

import java.io.InputStream;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class HandReader {

    private InputStream stream;

    public HandReader(InputStream in) {
        this.stream = in;
    }

    public Hand obtainForPlayer(String playerName) {
        Scanner scanner = new Scanner(stream);
        String data = scanner.nextLine();
        Set<Card> cards = transform(data);
        return new Hand(playerName, cards);
    }

    private Card build(String scalar) {
        if(scalar.length() != 2)
            throw new IllegalArgumentException("The data must be exactly two characters");
        CardValue value = CardValue.read(scalar.charAt(0));
        Suit suit =  Suit.read(scalar.charAt(1));
        return new Card(value, suit);
    }

    private Set<Card> transform(String data) {
        Set<Card> result = new HashSet<>();
        String cleaned = data.replaceAll("\\s+"," ").trim();
        String[] vector = cleaned.split(" ");
        for(String scalar: vector)
            result.add(build(scalar));
        return result;
    }

}
