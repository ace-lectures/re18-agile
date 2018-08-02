package bdd;

import org.junit.Test;
import re.poker.Game;
import re.poker.cards.*;

import java.util.Set;

import static org.junit.Assert.*;
import static re.poker.cards.CardValue.*;
import static re.poker.cards.Suit.*;

public class AcceptanceTest {

    @Test
    public void readARegularHand() {
        Game theGame = new Game();
        theGame.submit("Bob", new Hand("QD TS 2C KD 3C"));
        Set<Card> cards = theGame.getByPlayer("Bob").getCards();
        assertEquals(5,cards.size());
        assertTrue(cards.contains(new Card(QUEEN, DIAMONDS)));
        assertTrue(cards.contains(new Card(TEN, SPADES)));
        assertTrue(cards.contains(new Card(TWO, CLUBS)));
        assertTrue(cards.contains(new Card(KING, DIAMONDS)));
        assertTrue(cards.contains(new Card(THREE, CLUBS)));
    }


    @Test(expected = IllegalArgumentException.class)
    public void rejectDuplicatedCardsInASingleHand() {
        Game theGame = new Game();
        theGame.submit("Bob", new Hand("QD TS 2C KD QD"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejectDuplicatedCardsInMultipleHands() {
        Game theGame = new Game();
        theGame.submit("Bob", new Hand("AC KC QC JC TC"));
        theGame.submit("Bob", new Hand("QD QH QS QC KD"));
    }

}
