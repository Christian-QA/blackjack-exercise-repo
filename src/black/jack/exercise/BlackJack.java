package black.jack.exercise;

	public class BlackJack {
		
		public int card() {   /// This method creates individual cards
			
			double randomDouble = Math.random();  /// Chooses card
			randomDouble = randomDouble * 14 + 1;   /// from 1 to 14
			int randomInt = (int) randomDouble;
			
			int setNum = 0;
			
			if (randomInt == 11) {					//// These statements convert 
				String displayedCard = "Jack!";		/// Higher than 10s to their royal
				System.out.println(displayedCard);	/// counterparts. With their correct
				setNum = randomInt - 1;				/// value.
			} else if (randomInt == 12) {
				String displayedCard = "Queen!";
				System.out.println(displayedCard);
				setNum = randomInt - 2;
			} else if (randomInt == 13) {
				String displayedCard = "King!";
				System.out.println(displayedCard);
				setNum = randomInt - 3;
			} else if (randomInt == 14) {
				String displayedCard = "Ace!";
				System.out.println(displayedCard);
				setNum = randomInt - 3;
			} else {
				String displayedCard = Integer.toString(randomInt);
				System.out.println(displayedCard);
				setNum = randomInt;
			}
			
			return setNum;  /// Sets the value of the card to be retrieved by result()
			
		}	
			
		public int result(int player) {
			
			BlackJack playerCard1 = new BlackJack(); 		/// Chooses card 1
			BlackJack playerCard2 = new BlackJack();		/// Chooses card 2
			int playerHand = playerCard1.card() + playerCard2.card();
			
			while (playerHand < 16) {
				BlackJack playerCardAdditional = new BlackJack();		
				playerHand = playerHand + playerCardAdditional.card();
			}	/// Adds additional for common dealer rules (check at 16)
			
			System.out.println("Player " + player + "'s hand: " + playerHand); // Show's player's hand

			return playerHand; /// Sets the total hand for the player to be retrieved by bust checker

		}
					
		public static void bustChecker(int playerCount) {  /// Also finds winner
			
			int[] playerHandFinal = { 1,2,3,4,5,6,7,8,9};  /// Declare's each player's hand at the end
			int winningHand = 1;	/// Used to find winner. Changes if new best hand is found through iterations
			
			String[] playerHandStatus = { "", "", "", "", "", "", "", "","" };
			
			int i;
			for (i = 1; i <= playerCount; i++) {	/// Creates players and their hands
			
				BlackJack playerHandRetriever = new BlackJack();	
				playerHandFinal[i] = playerHandRetriever.result(i);
							
				if (playerHandFinal[i] > 21) { 		/// Player status, checks for bust
					
					playerHandStatus[i] = "Bust";
					System.out.println(playerHandStatus[i]);
					playerHandFinal[i] = 0;
					
					
				} else if (playerHandFinal[i] == 21) {
					
					playerHandStatus[i] = "Blackjack!";
					System.out.println(playerHandStatus[i]);
					
				} else { 
					
					playerHandStatus[i] = "" + playerHandFinal[i];
					System.out.println(playerHandStatus[i]);
					
				}
				
				if (playerHandFinal[i] > playerHandFinal[winningHand]) { /// Compares current player with the winners hand
																		/// Defaulting to player 1 until a better hand is found
					winningHand = i;  /// Changes winner hand to new highest
					
				}		
				
					System.out.println("-------------------------------");  /// Divides players
				
			}
			
			System.out.println("The winner is: player " + winningHand +
					" who scored a " + playerHandStatus[winningHand]);   /// Show who's the winner and their hand

		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	