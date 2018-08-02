package re.poker.cards;

import org.junit.Test;
import re.poker.Helpers;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;

public class HandTest {

    @Test(expected = IllegalArgumentException.class)
    public void rejectAnHandWithTooManyCards() { new Hand(Helpers.TOO_MANY_CARDS); }

    @Test(expected = IllegalArgumentException.class)
    public void rejectAnHandWithNotEnoughCards() { new Hand(Helpers.NOT_ENOUGH_CARDS); }

    @Test(expected = IllegalArgumentException.class)
    public void rejectAnHandWithDuplicatedCards() { new Hand(Helpers.WITH_DUPLICATES); }

    @Test
    public void properlyBuildAnHand() {
        Hand theHand = new Hand("7S 6H 4S 3D 2C");
        assertTrue(theHand.getCards().contains(new Card("7S")));
        assertTrue(theHand.getCards().contains(new Card("6H")));
        assertTrue(theHand.getCards().contains(new Card("4S")));
        assertTrue(theHand.getCards().contains(new Card("3D")));
        assertTrue(theHand.getCards().contains(new Card("2C")));
    }

    @Test
    public void readAPokerHandFromAStream(){
        Hand obtained = new Hand(string2stream("AC KC QC JC TC"));
        assertEquals(Helpers.ROYAL_FLUSH, obtained);
    }

    private InputStream string2stream(String data) {
        try {
            return new ByteArrayInputStream(data.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException use) {
            throw new RuntimeException(use);
        }
    }

}
