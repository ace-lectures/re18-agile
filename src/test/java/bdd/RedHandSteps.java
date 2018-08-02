package bdd;

import cucumber.api.java.en.*;
import re.poker.cards.Hand;
import re.poker.cards.HandReader;
import re.poker.cards.deck.Card;
import re.poker.cards.deck.CardValue;
import re.poker.cards.deck.Suit;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;

public class RedHandSteps {

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
        HandReader reader = new HandReader(string2stream(data));
       try {
            this.givenHand = reader.obtainForPlayer(playerName);
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
        Card theCard = new Card(v,s);
        assertTrue(givenHand.getCards().contains(theCard));
    }

    @Then("^the game detect a cheat attempt$")
    public void detectCheaters() {
        assertTrue(this.cheater);
    }



    private InputStream string2stream(String data) {
        try {
            return new ByteArrayInputStream(data.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException use) {
            throw new RuntimeException(use);
        }
    }

}

