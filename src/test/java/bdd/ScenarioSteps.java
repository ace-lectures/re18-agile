package bdd;

import cucumber.api.java.en.*;
import re.poker.Game;
import re.poker.cards.*;

import static org.junit.Assert.*;

public class ScenarioSteps {

    private Game theGame;
    private boolean cheatingDetected;

    @Given("^a new game$")
    public void startNewGame() {
        this.theGame = new Game();
        this.cheatingDetected = false;
    }

    @When("^(.*) submits the following cards: (.*)$")
    public void enterPlayerHand(String thePlayer, String data){
       try {
            this.theGame.submit(thePlayer, new Hand(data));
       } catch (IllegalArgumentException iae) { this.cheatingDetected = true; }
    }

    @Then("^(.*)'s hand contains (\\d+) cards$")
    public void checkHandSize(String thePlayer, int n) {
        assertEquals(n, theGame.getByPlayer(thePlayer).getCards().size());
    }

    @Then("^(.*)'s hand contains the (.*) of (.*)$")
    public void checkHandSize(String thePlayer, String value, String suit) {
        CardValue v = CardValue.valueOf(value.trim());
        Suit s = Suit.valueOf(suit.trim());
        Card theCard = new Card(v.getSymbol()+""+s.getSymbol());
        assertTrue(theGame.getByPlayer(thePlayer).getCards().contains(theCard));
    }

    @Then("^a cheat attempt is detected!$")
    public void detectCheaters() {
        assertTrue(this.cheatingDetected);
    }

}

