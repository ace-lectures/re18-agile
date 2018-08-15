Feature: Reading a Poker Hand

  Scenario: Read a regular hand
    Given a new game
    When Bob submits the following cards: QD TS 2C KD 3C
    Then Bob's hand contains 5 cards
      And Bob's hand contains the QUEEN of DIAMONDS
      And Bob's hand contains the TEN   of SPADES
      And Bob's hand contains the TWO   of CLUBS
      And Bob's hand contains the KING  of DIAMONDS
      And Bob's hand contains the THREE of CLUBS

  Scenario: Reject an hand with a duplicated card
    Given a new game
    When Bob submits the following cards: QD TS 2C KD QD
    Then a cheat attempt is detected!

  Scenario: Detect cheaters when submitting duplicated cards
    Given a new game
    When Bob submits the following cards: AC KC QC JC TC
      And Alice submits the following cards: QD QH QS QC KD
    Then a cheat attempt is detected!

  Scenario: Identify the highest card in an hand
    Given a new game
    When Bob submits the following cards: AC KC QC JC TC
    Then Bob's highest card is the ACE of CLUBS