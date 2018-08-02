package re.poker.cards;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SuitTest {
    
    @Test
    public void checkMappingBetweenSymbolsAndSuits() {
        for(Suit suit: Suit.values()) {
            assertEquals(suit, Suit.read(suit.getSymbol()));
        }
    }

}
