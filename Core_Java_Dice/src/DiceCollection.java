import java.util.Arrays;

public class DiceCollection {
	private Dice dice[];
	public int min=0;
	public int max=0;
	public int current=0;
	public int status[];
	public DiceCollection() {
	}

	public DiceCollection(int sides[]) {
		dice = new Dice[sides.length];
		for(int i=0;i<sides.length;i++){
			dice[i] = new Dice(sides[i]);
		}
		min = sides.length;
		
		for(int i=0;i<sides.length;i++){
			max= max + sides[i];
		}
	}
	
	public Dice[] getDice() {
		return dice;
	}

	public void setDice(Dice[] dice) {
		this.dice = dice;
	}

	public void rollDiceCollection(double roll){
		System.out.println(dice.length);
		if(roll==1){
			for(int i=0;i<dice.length;i++){
				dice[i].rollDice();
			}
			for(int i=0;i<dice.length;i++){
				current = current + dice[i].getNo_on_top();
			}
			String message=toString();
			System.out.println(message);
		}
		else if(roll==100000){
			status=new int[max-min+1];
			for(int k=0;k<100000;k++){
				for(int i=0;i<dice.length;i++){
					dice[i].rollDice();
				}
				current=0;
				for(int i=0;i<dice.length;i++){
					current+=dice[i].getNo_on_top();
				}
				status[current-min]++;
			}
		}
		else {
			
		}
	}
	public char[] graph() {
		System.out.println();
		for(int i = 0; i < max - min + 1; i++){
			System.out.print((i+min)+":"+status[i]);
			int stars = status[i] / 1000;
			for(int j = 0; j < stars; j++){
				System.out.print("*");
		}
		String message=toString();
		System.out.println(message);
		}
		return null;
	}
	@Override
	public String toString() {
		return "DiceCollection: \n" + Arrays.toString(dice) + "\n min=" + min
				+ ",\n max=" + max + ",\n current=" + current;
	}
}
