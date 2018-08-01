package re.poker;

import re.poker.cards.Hand;
import re.poker.cards.HandReader;

public class Main {


    public static void main(String[] args) {
        HandReader reader = new HandReader(System.in);

        System.out.print("Enter Black's hand: ");
        Hand black = reader.obtainForPlayer("Black");
        System.out.println(black);

        System.out.print("Enter White's hand: ");
        Hand white = reader.obtainForPlayer("White");
        System.out.println(white);

        // ...
    }

}
