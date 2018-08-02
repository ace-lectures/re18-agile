package re.poker;

import org.junit.Test;
import re.poker.cards.Hand;
import re.poker.cards.HandReader;
import re.poker.cards.deck.Card;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static re.poker.cards.deck.CardValue.*;
import static re.poker.cards.deck.Suit.*;


public class HandTest {

    String hand = "QD TS 2C KD 3C";
    Set<Card> expected = new HashSet<>(Arrays.asList(
            new Card(QUEEN, DIAMONDS), new Card(TEN, SPADES),
            new Card(TWO, CLUBS),      new Card(KING, DIAMONDS),
            new Card(THREE, CLUBS)));

    @Test
    public void enterAPokerHand(){
        HandReader reader = new HandReader(string2stream(hand));
        Hand obtained = reader.obtainForPlayer("Bob");
        assertEquals(expected, obtained.getCards());
    }

    @Test(expected = IllegalArgumentException.class)
    public void noDuplicateInHand() {
        HandReader reader = new HandReader(string2stream("QD TS 2C KD QD"));
        reader.obtainForPlayer("Bob");
    }

    private InputStream string2stream(String data) {
        try {
            return new ByteArrayInputStream(data.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException use) {
            throw new RuntimeException(use);
        }
    }

}
