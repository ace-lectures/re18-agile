package re.poker.cards;

import java.util.*;

/**
 * Note: this class has a natural ordering that is inconsistent with equals
 *   - Two of Spades does not equals to Two of Hearts
 * However,
 *   - Two of Spades isn't greater than nor lesser than Two of Hearts.
 */
public class Card implements Comparable<Card> {

    private CardValue value;
    private Suit suit;

    public CardValue getValue() { return value; }
    public Suit getSuit() { return suit; }

    public Card(String description) {
        if(description.length() != 2)
            throw new IllegalArgumentException("Card descriptor must be exactly two characters");
        this.value = CardValue.read(description.charAt(0));
        this.suit =  Suit.read(description.charAt(1));
    }

    @Override public int compareTo(Card that) { return this.value.compareTo(that.getValue()); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return value == card.value && suit == card.suit;
    }

    @Override public int hashCode() { return Objects.hash(value, suit); }
    @Override public String toString() { return value + " of " +suit; }

}
