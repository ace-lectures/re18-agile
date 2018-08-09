package re.poker;

import re.poker.cards.Hand;

import java.util.Collections;

public class Main {


    public static void main(String[] args) {

        Game theGame = new Game();

        System.out.print("Enter 1st player hand: ");
        Hand first = new Hand(System.in);
        System.out.println("1st: " + first);
        System.out.println("  Highest card: " + Collections.max(first.getCards()));
        theGame.submit("1st", first);

        System.out.print("Enter 2nd player hand: ");
        Hand second = new Hand(System.in);
        System.out.println("2nd: " + second);
        theGame.submit("2nd", second);

        System.out.println("And the winner is: " + theGame.declareWinner());

    }

}
