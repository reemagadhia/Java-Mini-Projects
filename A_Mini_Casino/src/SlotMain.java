import java.util.Scanner;

public class SlotMain {
	public static void main(String[] args) {
		SlotMachine machine1 = new SlotMachine();
		SlotMachine machine2 = new SlotMachine();
		Scanner scanner = new Scanner(System.in);
		Double balance;
		int choice;
		do {
			System.out.println("\nYou want to play with:\n" + "1. Slot Machine 1\n" + "2. Slot Machine 2\n"
					+ "3. Quit\n" + "Please Enter your choice:");
			choice = scanner.nextInt();

			switch (choice) {

			case 1:
				int choiceOfMachine1;
				do {
					System.out
							.println("\n1. Insert Quarter\n" + "2. Spin Wheels\n" + "3. Display\n" + "4. View Balance\n"
									+ "5. Reload with Cash\n" + "6. Quit\n" + "Please Enter your choice ->");
					choiceOfMachine1 = scanner.nextInt();
					switch (choiceOfMachine1) {
					case 1:
						System.out.println("INSERT QUARTER");
						machine1.insertQuarter();
						break;

					case 2:
						machine1.spinWheels();
						break;

					case 3:
						System.out.println("\nFRUITS GENERATED ARE: ");
						machine1.displayFruits();
						break;

					case 4:
						System.out.println("Total amount of money in the machine is: " + machine1.getBalance());
						break;

					case 5:
						System.out.println("Enter cash amount you want to reload:");
						Double reloadCash = scanner.nextDouble();
						balance = machine1.reloadCash(reloadCash);
						System.out.println("---CASH ADDED SUCCESSFULLY---");
						break;

					case 6:
						break;

					default:
						System.out.println("INVALID CHOICE");
					}
				} while (choiceOfMachine1 != 6);
				break;

			case 2:
				int choiceOfMachine2;
				do {
					System.out
							.println("\n1. Insert Quarter\n" + "2. Spin Wheels\n" + "3. Display\n" + "4. View Balance\n"
									+ "5. Reload with Cash\n" + "6. Quit\n" + "Please Enter your choice ->");
					choiceOfMachine2 = scanner.nextInt();
					switch (choiceOfMachine2) {

					case 1:
						System.out.println("INSERT QUARTER");
						machine2.insertQuarter();
						break;

					case 2:
						machine2.spinWheels();
						break;

					case 3:
						System.out.println("\nFRUITS GENERATED ARE: ");
						machine2.displayFruits();
						break;
					case 4:
						System.out.println("Total amount of money in the machine is: " + machine2.getBalance());
						break;

					case 5:
						System.out.println("Enter cash amount you want to reload:");
						Double reloadCash = scanner.nextDouble();
						balance = machine1.reloadCash(reloadCash);
						System.out.println("---CASH ADDED SUCCESSFULLY---");
						break;

					case 6:
						break;

					default:
						System.out.println("INVALID CHOICE");
					}
				} while (choiceOfMachine2 != 6);
				break;

			case 3:
				break;

			default:
				System.out.println("INVALID CHOICE");
			}
		} while (choice != 3);
		System.out.println("You Quit");
	}
}
