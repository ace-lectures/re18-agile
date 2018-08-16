package re.poker;

import org.junit.Ignore;
import org.junit.Test;

import re.poker.cards.Hand;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Map;

public class GameTest {

    @Test(expected = IllegalArgumentException.class)
    public void rejectNonLegitHands() {
        Game theGame = new Game();
        theGame.submit("Bob", Helpers.FOUR_OF_A_KIND);
        theGame.submit("Alice", Helpers.FULL_HOUSE);
    }

    @Test
    @Ignore
    public void declareTheWinner() {
        Game theGame = new Game();
        theGame.submit("Bob", Helpers.HIGH_CARD);
        theGame.submit("Alice", Helpers.STRAIGHT_FLUSH);
        assertEquals("Alice", theGame.declareWinner());
    }
    @Test
    @Ignore
    public void compareTwoHandsAccordingToHC() {
        Game theGame = new Game();
        Hand highest = new Hand("AD KD QD JD TD");
        Hand lowest =  new Hand("8C 7C 6C 5C 4C");
        theGame.submit("Bob",  lowest);
        theGame.submit("Alice", highest);
        Map.Entry<String, Hand> obtained = theGame.winnerByHC();
        assertEquals("Alice", obtained.getKey());
        assertEquals(highest, obtained.getValue());
    }

    @Test
    @Ignore
    public void compareHCWhenExAequo() {
        Game theGame = new Game();
        theGame.submit("Bob",   new Hand("AC KC QC JC TC"));
        theGame.submit("Alice", new Hand("AD KD QD JD TD"));
        Map.Entry<String, Hand> obtained = theGame.winnerByHC();
        assertNull(obtained);
    }
}
