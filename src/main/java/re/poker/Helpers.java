package re.poker;

import re.poker.cards.Hand;
import re.poker.cards.Card;

public class Helpers {

    // Cards

    public static final Card TWO_OF_HEARTS   = new Card("2H");
    public static final Card TWO_OF_SPADES   = new Card("2S");
    public static final Card THREE_OF_SPADES = new Card("3S");
    public static final Card FIVE_OF_HEARTS  = new Card("5H");

    // Illegal Hand Descriptors

    public static final String TOO_MANY_CARDS   = "QD TS 2C KD 3C KS";
    public static final String NOT_ENOUGH_CARDS = "QD";
    public static final String WITH_DUPLICATES  = "QD TS 2C KD QD";

    // Regular hands (with overlap)

    public static final Hand ROYAL_FLUSH     = new Hand("AC KC QC JC TC");
    public static final Hand STRAIGHT_FLUSH  = new Hand("4H 5H 6H 7H 8H");
    public static final Hand FOUR_OF_A_KIND  = new Hand("QD QH QS QC KD");
    public static final Hand FULL_HOUSE      = new Hand("QD QS 3D 3H 3S");
    public static final Hand FLUSH           = new Hand("3D 6D TD QD AD");
    public static final Hand STRAIGHT        = new Hand("4C 5D 6H 7H 8S");
    public static final Hand THREE_OF_A_KIND = new Hand("5D JC 8C 8H 8D");
    public static final Hand TWO_PAIRS       = new Hand("QD QH KC KH 3S");
    public static final Hand PAIR            = new Hand("TS JD 7S 6H 6C");
    public static final Hand HIGH_CARD       = new Hand("7S 6H 4S 3D 2C");

}
