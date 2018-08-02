package re.poker.cards;

import java.util.Arrays;

public enum CardValue {

    TWO(  '2', 2),  THREE('3', 3), FOUR( '4', 4),
    FIVE( '5', 5),  SIX(  '6', 6), SEVEN('7', 7),
    EIGHT('8', 8),  NINE( '9', 9), TEN(  'T', 10),
    JACK( 'J', 11), QUEEN('Q', 12), KING( 'K', 13),
    ACE(  'A', 14);

    private final char symbol;
    public char getSymbol() { return symbol; }

    private final int value;
    public int getValue() { return value; }

    CardValue(char symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }

    public static CardValue read(char c) {
        return Arrays.stream(CardValue.values()).filter((CardValue v) -> v.symbol == c)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown value symbol: " + c));
    }

}
