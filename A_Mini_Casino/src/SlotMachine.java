public class SlotMachine {
	private Double balance = (double) 0;
	private int fruit[] = { 0, 0, 0 };
	private String fruitnames[] = { "Mango", "Orange", "Grapes", "Apple", "Banana", "Pineapple", "Strawberries" };
	private int MAX_NO_OF_FRUIT = 7;

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double reloadCash(Double cash) {
		Double balance = getBalance();
		balance = cash + getBalance();
		setBalance(balance);
		return balance;
	}

	public void insertQuarter() {
		Double balance = getBalance() + 1;
		setBalance(balance);
		System.out.println("\n---NOW SPIN THE WHEELS---\n");
	}

	public void spinWheels() {
		Double balance = getBalance();
		if (balance >= 50) {
			for (int i = 0; i < fruit.length; i++) {
				fruit[i] = (int) (Math.random() * MAX_NO_OF_FRUIT);
			}
			displayFruits();
			generatePayout();
			System.out.println("Wheels Spinned\n");
		} else if (balance == 0) {
			System.out.println("Please insert the quarter first");
		} else {
			System.out.println("\n-------LOW BALANCE!!!!-------\nFirstly reload the machine with cash.\n");
		}
	}

	public void displayFruits() {
		if (balance >= 50) {
			for (int i = 0; i < fruit.length; i++) {
				System.out.print(fruitnames[fruit[i]] + " ");
			}
			System.out.println("\n");
		} else {
			System.out.println("\nSpin the wheel to generate fruits.");
		}
	}

	public void generatePayout() {
		Double balance = getBalance();
		if ((fruit[0] == fruit[1]) && (fruit[1] == fruit[2])) {
			balance = getBalance() - 50;
		} else if (((fruit[0] == fruit[1]) && (fruit[1] != fruit[2]))
				|| ((fruit[1] == fruit[2]) && (fruit[0] != fruit[2]))
				|| ((fruit[0] == fruit[2] && (fruit[0] != fruit[1])))) {
			balance = getBalance() - 20;
		} else if ((fruit[0] < fruit[1]) && (fruit[1] < fruit[2])) {
			balance = getBalance() - 10;
		} else if ((fruit[0] > fruit[1]) && (fruit[1] > fruit[2])) {
			balance = getBalance() - 10;
		} else {
			balance = getBalance();
		}
		setBalance(balance);
	}
}
