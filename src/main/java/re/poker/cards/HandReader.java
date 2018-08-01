package re.poker.cards;

import java.io.InputStream;
import java.util.Scanner;
import java.util.Set;

public class HandReader {

    private InputStream stream;
    private HandFactory factory;

    public HandReader(InputStream in) {
        this.stream = in;
        this.factory = new HandFactory();
    }

    public Hand obtainForPlayer(String playerName) {
        Scanner scanner = new Scanner(stream);
        System.out.println("Player " + playerName + ": ");
        String data = scanner.nextLine();
        Set<Card> cards = factory.transform(data);
        return new Hand(playerName, cards);
    }
}
