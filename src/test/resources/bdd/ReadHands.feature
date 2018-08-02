Feature: Reading a Poker Hand

  Scenario: Read a regular hand
    Given a player named Bob
    When he enters the following cards: QD TS 2C KD 3C
    Then his hand contains 5 cards
      And contains the QUEEN of DIAMONDS
      And contains the TEN   of SPADES
      And contains the TWO   of CLUBS
      And contains the KING  of DIAMONDS
      And contains the THREE of CLUBS


  Scenario: Read an hand with a duplicated card
    Given a player named Bob
    When he enters the following cards: QD TS 2C KD QD
    Then the game detect a cheat attempt

