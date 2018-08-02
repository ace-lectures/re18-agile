package re.poker.cards;

import java.util.Arrays;

public enum Suit {

    CLUBS('C', "Clubs"),  DIAMONDS('D', "Diamonds"),
    HEARTS('H', "Hearts"), SPADES(  'S', "Spades");

    private final char symbol;
    public char getSymbol() { return symbol; }

    private final String name;
    public String getName() { return name; }

    Suit(char c, String n) {
        this.name = n;
        this.symbol = c;
    }

    public static Suit read(char c) {
        return Arrays.stream(Suit.values()).filter((Suit s) -> s.symbol == c)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown suit symbol: " + c));
    }

}