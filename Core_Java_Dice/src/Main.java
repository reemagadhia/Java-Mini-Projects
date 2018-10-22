import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many Dice you want?");
		int no_of_dice = scanner.nextInt();
		
		System.out.println("\nEnter no of sides of each Dice:");
		int sides[]= new int[no_of_dice];
		for(int i=0;i<sides.length;i++){
			sides[i] = scanner.nextInt();
		}
		DiceCollection dice_coll = new DiceCollection(sides);
		int choice;
		do{
			System.out.println("\n\nEnter your choice:\n"
					+ "1. Roll once\n"
					+ "2. Roll 100000 times\n"
					+ "3. Quit");
			choice = scanner.nextInt();
			switch(choice){
			case 1:
				dice_coll.rollDiceCollection(1);
				break;
				
			case 2:
				dice_coll.rollDiceCollection(100000);
				dice_coll.graph();
				break;
				
			case 3:
				System.out.println("\nBBYE");
				break;
				
			default:
				break;
			}
		}while(choice!=3);
	}

}
