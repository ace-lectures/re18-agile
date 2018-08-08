# Step 3: Implementing stories & Tests

  * Previous step: [Writing epics and stories](./step2.md)

## Iteration Backlog

the rationale of ou first iteration is to develop a Minimal and Viable Product. As a consequence, we engaged stories 
that allows a player to submit the contents of his hand, detects the easiest combination (_Highest Card_, HC) and 
declares a winner. We also engaged a story related to Alice's fear of having cheaters at her table, as it has a lot of 
value for this persona. 

We consider here the following iteration backlog.

  1. As Bob, I want to enter my hand on the command line so that the game knows the contents of my hand;
      - Story points: 8
      - Business value: 40 
      - Acceptance scenario: One enters a regular hand according to the input syntax. The system echoes as output the 
        contents of the submitted hands in understandable terms (_e.g._, `QD` :twisted_rightwards_arrows: _Queen of 
        Diamonds_)
  2. As Alice, I want to identify cheaters that trick the card deck so that I can report cheating attempts to management
      - Story points: 20
      - Business value: 13
      - Acceptance scenario: One enters two overlapping hands (_e.g._ the two hands contains a `QD`). The 
        game echoes an error stating it encountered a cheat attempts.
  3. As Bob, I want to know which is the highest card in my hand so that I can know the value of the HC combination
      - Story points: 1
      - Business value: 0,5
      - Acceptance scenario: One enters an hand. The value of its highest card is printed on screen.
  4. As Alice, I want to compare two hands according to the HC combination so that I can identify the winner
      - Story points: 3
      - Business value: 3
      - Acceptance scenario: One enters two hands. The winning hand according to the HC combination is printend on 
        screen


This iteration aims to deliver 56,5 units of business value, associated to a load of 32. These are relative units, not
 absolute ones. The Kanban board of the team looks like the following today:

| TO DO | IN PROGRESS | DONE |
| ---   | ---         | ---  |
| #4    |  #3         |  #1  |
|       |             |  #2  | 

## Running the existing product

According to the Kanban board, our development team had already started the development. First of all, you have to 
clone this repository on your computer: 

    azrael:~ mosser$ git clone https://github.com/mosser/agile-tutorial.git
    azrael:~ mosser$ cd agile-tutorial
    azrael:agile-tutorial mosser$

To compile the existing code, you simply have to invoke Maven from the command line, asking the build tool to 
first `clean` your environment and then `package` it. We will skip tests for now, as we focus on the business code.

    azrael:agile-tutorial mosser$ mvn -DskipTests clean package

The previous command should end by printing `BUILD SUCCESS` to the standard output. It produced a file named 
`poker-game.jar` that contains an executable version of the poker game. To run the game, simply asks java to do so:

    azrael:agile-tutorial mosser$ java -jar target/poker-game.jar 
    Enter 1st player hand: QD QH KC KH 3S
    1st: [KING of HEARTS, QUEEN of DIAMONDS, THREE of SPADES, QUEEN of HEARTS, KING of CLUBS]
    Enter 2nd player hand: 7S 6H 4S 3D 2C
    2nd: [FOUR of SPADES, SEVEN of SPADES, TWO of CLUBS, SIX of HEARTS, THREE of DIAMONDS]
    Exception in thread "main" java.lang.UnsupportedOperationException: Cannot determine winner!
            at re.poker.Game.declareWinner(Game.java:23)
            at re.poker.Main.main(Main.java:22)

### :bangbang: Exercise

  - Stories #1 and #2 are considered _DONE_ by the team. Can you validate this statement by using the product? 


### :rotating_light: Implementation status

  - The game is developed in the `src/main/java` directory, in a package named `re.poker`;
  - The `Main` class contains the UI, asking for two hands, printing the hands to `stdout` and trying to determine the 
    winner of the game;
  - The `cards` subpackage defines an `Hand` as a set of `Card`s. A `Card` is a tuple containing a `CardValue` and a 
    `Suit`. Both values and suits are represented as enumerated types to simplify the input parsing;
  - The `Card` class implements the `Comparable` interface: `card1.compareTo(card2)` returns a negative number if 
    `card1` < `card2`, `0` if they have the same value, and a positive number otherwise. Be careful that in this case 
    having the same value does not means being equals : 
      - 2:spades:`.equals(`2:hearts:`) != true`, but
      - 2:spades:`.compareTo(`2:hearts:`) == 0`
  - The `Game` class collects hands from players, assess their legitimacy and identify the winning one;


  * Next step: [Executing acceptance scenarios](./step4.md)
