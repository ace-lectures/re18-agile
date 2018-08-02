package re.poker.cards;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardValueTest {

    @Test
    public void checkMappingBetweenSymbolsAndValues() {
        for(CardValue value: CardValue.values()) {
            assertEquals(value, CardValue.read(value.getSymbol()));
        }
    }

}
