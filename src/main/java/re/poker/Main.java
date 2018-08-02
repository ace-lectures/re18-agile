package re.poker;

import re.poker.cards.Hand;

public class Main {


    public static void main(String[] args) {

        Game theGame = new Game();

        System.out.print("Enter 1st player hand: ");
        theGame.submit("1st", new Hand(System.in));

        System.out.print("Enter 2nd player hand: ");
        theGame.submit("2nd", new Hand(System.in));

        System.out.println("And the winner is: " + theGame.declareWinner());

    }

}
