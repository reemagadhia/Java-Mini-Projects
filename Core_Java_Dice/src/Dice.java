import java.util.Scanner;


public class Dice {
	private int sides;
	private int no_on_top=1;
	
	public Dice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dice(int sides) {
		super();
		this.sides = sides;
	}
	
	public int getSides() {
		return sides;
	}
	public void setSides(int sides) {
		this.sides = sides;
	}
	public int getNo_on_top() {
		return no_on_top;
	}
	public void setNo_on_top(int no_on_top) {
		this.no_on_top = no_on_top;
	}
	
	public void rollDice(){
		setSides(sides);
		no_on_top=(int)(Math.random()*sides)+1;
		setNo_on_top(no_on_top);
	}
	@Override
	public String toString() {
		return "Dice" + sides + ": no on top=" + no_on_top+"\n";
	}
	public static void main(String[] args) {
		int sides = 0;
		Dice dice=new Dice(sides);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter no of sides");
		sides = scanner.nextInt();
		dice.setSides(sides);
		dice.rollDice();
		System.out.print(dice.getNo_on_top());
	}
}
