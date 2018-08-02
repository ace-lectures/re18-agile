package re.poker.cards;

import org.junit.Test;

import static org.junit.Assert.*;
import static re.poker.Helpers.*;


public class CardTest {

    @Test
    public void identifyDifferentCardsBasedOnValues() {
        assertNotEquals(TWO_OF_SPADES, THREE_OF_SPADES);
    }

    @Test
    public void identifyDifferentCardsBasedOnSuits() {
        assertNotEquals(TWO_OF_SPADES, TWO_OF_HEARTS);
    }

    @Test
    public void identifyEqualsCard() {
        assertEquals(TWO_OF_SPADES, TWO_OF_SPADES);
        assertEquals(TWO_OF_SPADES, new Card("2S"));
    }

    @Test
    public void orderCardsBasedOnValues() {
        assertTrue(TWO_OF_HEARTS.compareTo(FIVE_OF_HEARTS) < 0);
        assertTrue(FIVE_OF_HEARTS.compareTo(TWO_OF_HEARTS) > 0);
    }

    @Test
    public void comparisonDiffersFromEquality() {

        assertEquals(0, TWO_OF_HEARTS.compareTo(TWO_OF_HEARTS));
        assertEquals(TWO_OF_HEARTS, TWO_OF_HEARTS);

        assertEquals(0, TWO_OF_SPADES.compareTo(TWO_OF_SPADES));
        assertEquals(TWO_OF_SPADES, TWO_OF_SPADES);

        assertNotEquals(TWO_OF_HEARTS, TWO_OF_SPADES);
        assertEquals(0, TWO_OF_HEARTS.compareTo(TWO_OF_SPADES));
        assertEquals(0, TWO_OF_SPADES.compareTo(TWO_OF_HEARTS));
    }

}
