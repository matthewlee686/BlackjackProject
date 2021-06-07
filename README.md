## Blackjack Project

###Overview
* This Project is a simple Blackjack Game. There is one Player and a Dealer. At the moment, there is only one round, but plans to implement multiple rounds will be added.

* The game starts by issuing an initial hand to both the Player and the Dealer.

* The Dealer's first card will read "Face Down Card" to simulate hiding it from the Player's view. The actual value of this card will be revealed at the end of the round.

* Various checks for the winner have been implemented throughout the game. If at any point during a Hit the Player or Dealer goes over or hits Blackjack, the winner will be determined and the round will end. Both hands are revealed.

* There are 3 possibilities at the end of the round: Player wins, Dealer wins, or the Round is a tie

### Technologies Used
* Java
* Enums
* Object-Oriented design

### Lessons Learned
* Implementing game behavior - specifically with the Dealer as the Computer must control the actions based on the provided conditions

* How to use StringBuilder to mask information without overwriting it

* Control flow and how to implement multiple checks and preemptively ending a program
