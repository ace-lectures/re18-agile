package re.poker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test(expected = IllegalArgumentException.class)
    public void rejectNonLegitHands() {
        Game theGame = new Game();
        theGame.submit("Bob", Helpers.FOUR_OF_A_KIND);
        theGame.submit("Alice", Helpers.FULL_HOUSE);
    }

    @Test
    public void declareTheWinner() {
        Game theGame = new Game();
        theGame.submit("Bob", Helpers.HIGH_CARD);
        theGame.submit("Alice", Helpers.STRAIGHT_FLUSH);
        assertEquals("Alice", theGame.declareWinner());
    }

}
