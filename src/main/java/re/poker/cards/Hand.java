package re.poker.cards;

import java.io.InputStream;
import java.util.*;
import static java.util.stream.Collectors.toSet;

public class Hand {

    private Set<Card> cards;
    public Set<Card> getCards() { return cards; }

    public Hand(String data) {
        this.cards = Arrays.stream(clean(data)).map(Card::new).collect(toSet());
        if(cards.size() != 5)
            throw new IllegalArgumentException("An hand must contains 5 cards!");
    }

    public Hand(InputStream input) { this(new Scanner(input).nextLine()); }

    public String toString() { return cards.toString(); }

    private String[] clean(String data) {
        return data.replaceAll("\\s+"," ").trim().split(" ");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hand hand = (Hand) o;
        return Objects.equals(cards, hand.cards);
    }

    @Override
    public int hashCode() { return Objects.hash(cards); }
}
