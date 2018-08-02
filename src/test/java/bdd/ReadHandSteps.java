package bdd;

import cucumber.api.java.en.*;
import re.poker.cards.*;

import static org.junit.Assert.*;

public class ReadHandSteps {

    private String playerName;
    private Hand givenHand;
    private boolean cheater;

    @Given("^a player named (.*)$")
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
        this.cheater = false;
    }

    @When("^(?:he|she) enters the following cards: (.*)$")
    public void enterPlayerHand(String data){
       try {
            this.givenHand = new Hand(data);
       } catch (IllegalArgumentException iae) {
            this.cheater = true;
       }
    }

    @Then("^(?:his|her) hand contains (\\d+) cards$")
    public void checkHandSize(int n) {
        assertEquals(n, givenHand.getCards().size());
    }

    @Then("^contains the (.*) of (.*)$")
    public void checkHandSize(String value, String suit) {
        CardValue v = CardValue.valueOf(value.trim());
        Suit s = Suit.valueOf(suit.trim());
        Card theCard = new Card(v.getSymbol()+""+s.getSymbol());
        assertTrue(givenHand.getCards().contains(theCard));
    }

    @Then("^the game detects a cheat attempt$")
    public void detectCheaters() {
        assertTrue(this.cheater);
    }


}

