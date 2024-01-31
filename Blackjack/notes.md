# Objective
This second set of activities will give you the chance to implement a few design patterns and unit tests.

# Description
For these activities, you are building and testing a head-to-head blackjack simulator (or at least a
simplified version of blackjack). Our game operates as follows:
1. At the start of a round, the dealer and the player are each given two playing cards.
2. The player is then asked if they wish to “hit” (that is, add another card from the deck to their
   hand). If the player wishes to hit, another card is added to their hand.
3. If the “total” of the player’s hand is less than or equal to 21, they are again asked if they wish to
   hit. This process repeats until either (i) the player’s hand’s total exceeds 21 (in which case they
   have “busted”), or (ii) the player “stands” (does not take another card).
    * The hand is scored as follows: pip cards (those with a number from 2-10 on them) have
      a value equal to their number, face cards (jacks, queens, kings) have a value of 10, and
      aces have a value of either 11 or 1 (whichever gets closest to 21 without going over)
4. If the player has not busted and has chosen to stand, then the dealer gets the chance to hit or
   stand. As with the other player, the dealer repeats this process until they stand or bust. If the
   other player has busted, the dealer does not take any cards.
5. The winner of this head-to-head matchup is whichever player is closest to 21 without going
   over. If the player wins, 1 point is added to their. If the player loses, 1 point is deducted from
   their score. If both the player and the dealer have the same total (which implies neither has
   busted, as the dealer would not draw otherwise), then the player’s score does not change. Note
   we do not need to directly track the dealer’s score.

If you have any questions on these rules, please don’t hesitate to ask me or your classmates! Please do
note they are a simplified version of blackjack: no need for things like splitting or doubling down, for
instance, or even multiple players.

# Activities
To implement the game above, you should complete the following steps in order:
1. Implement the Java classes necessary to represent a standard deck of 52 playing cards, as well
   as a blackjack card “shoe” (a collection of n 52 card decks, where n is a parameter to your
   shoe). The requirements for the deck, card, and shoe classes are:
    * A playing card has a suit and a rank, both of which are set when it is created and do not
      change. It can return the suit and rank, and also has a toString() method which
      returns a human-readable representation of the card. You are free to use any type for the
      suit and rank that you find appropriate, but I will point out that I can use a single integer
      from 0 to 51 to represent each card by taking this integer modulo 13 to get the “rank”,
      and the whole number component of taking this integer divided by 13 (aka integer
      division) to get the “suit”. Whichever way you choose to represent this, just keep in
      mind this representation isn’t for “human consumption”, but rather for your program to
      use later to score a blackjack hand (see below).
    * While we wouldn’t need this step, please humor me and create a playing card deck class.
      When created, it has all 52 playing cards. It can deal out cards one at a time and can also
      shuffle itself, putting the cards in a random order. Please make this implement the
      Iterable interface as well!
    * When created, a shoe is told how many decks it should consist of, and it fills itself with
      the contents of these n decks. A shoe should be able to “shuffle” all cards in it, deal cards
      out one at a time, return a count of the number of cards left, and reset itself to a new set
      of 52n cards. As with the deck, please have this implement the Iterable interface.
2. Implement the Java classes necessary for managing a simple game of blackjack (although not
   the game itself – that is in the next step). In particular, you’ll be creating a blackjack hand class,
   a blackjack player interface, and a simple implementation of this interface. A few notes about
   your implementation:
    * When created, a blackjack hand consists of 2 playing cards. The hand may have
      additional cards added to it. A hand is capable of returning its “score” using the “typical”
      rules of blackjack hand scoring listed above. As a hint for implementation, when scoring
      the hand, the goal is to return the score closest to 21 without going over, so you may
      assume aces are worth 11 initially, and only treat them as a 1 if the hand exceeds 21 (said
      in another way, if you assume each ace is worth 11 initially, you can then subtract 10 for
      every ace in your hand until you are under 21 or have no more aces scored as 11...). A
      hand also has a toString() method which returns the String representation of all
      cards in the hand.
    * In order for an object to be considered a player, it must be able to ...
        * ... be given a blackjack hand and return whether or not they wish to “hit” (add
          another card to the hand). I’d probably return a Boolean here and name this
          method something like willHitHand( Hand h ).
        * ... be shown the hand its opponent played in the last game (in case they want to
          do something like counting cards).
        * ... be told the shoe has reset and given the number of decks in the new shoe
          (again, for counting cards and such).
    * Implement your player interface using a simple “dealer” player which operates using the
      simple Atlantic City blackjack dealer rules: dealer always hits on totals of 16 or less and
      stays (does not take a card) on totals of 17 or more.
3. Implement the blackjack game class which manages the interactions of the objects you’ve
   created above, and also a simple driver. A few notes on this implementation:
    * When created, the blackjack game is given the size of the shoe it should use (in number
      of decks), the dealer player, and the other player. The game should create a shoe of the
      specified size, shuffle it, and inform the players of this “reset”.
    * The blackjack game can be told to play a single round. In response to this message, the
      game creates hands for each player and updates them based on the player choices and
      the rules specified at the top (e.g. two cards for each player initially, player goes first
      until they bust or stand, then dealer if player did not bust). The player score is updated
      based upon the results of the round, and each player should then be informed of the hand
      of the other. After the round is over, the game should check the shoe, and if the shoe
      reaches a length of 15 cards or less, it should be reset and all players notified.
    * The blackjack game can return the most-recent hands of the player and dealer when
      asked.
    * The blackjack game can be told to “play and print” n rounds, where n is a parameter.
      This will play n rounds, displaying the hands of the player and dealer after each round to
      standard output.
    * The blackjack game should provide the player’s score when asked.
    * Your driver should create a game pitting two simple “dealer players” against each other,
      play 500 hands, and print to standard output the final score of the player.
4. Implement two jUnit test classes: one that tests your blackjack hand class, and one which tests
   your simple dealer player’s willHitHand. Ensure you have 100% code coverage for the
   blackjack hand class and the willHitHand method.

# Scoring and Submission
Please submit your solution to the appropriate eLearning dropbox. Please reach out to me if you have
any questions!