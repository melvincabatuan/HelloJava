public class GreedyChange {

	public static void main(String[] args) {

		int denomination[] = new int[] { 25, 10, 5, 1 };
		int amount = 67;
		System.out.println("The minimal number of coins is " + change(denomination, amount) + ".");
                System.out.println("The minimal number of coins is " + change2(denomination, amount) + ".");
	}

	public static int change(int denomination[], int amount) {
                int numberOfCoins = 0;
                for (int i = 0; i<denomination.length; i++){
                     while (amount >= denomination[i]){
                         amount -= denomination[i];
                         numberOfCoins++;
                      }
                }
                return numberOfCoins;
	}


           
        public static int change2(int denomination[], int amount) {
                int numberOfCoins = 0;
                for (int i = 0; i<denomination.length; i++){
                     while (amount > 0){ 
                         if (amount - denomination[i] >= 0) { 
                             amount -= denomination[i];
                             numberOfCoins++;
                         }else
                             break;
                     }
                }
                return numberOfCoins;
	}

}// ENDCLASS
