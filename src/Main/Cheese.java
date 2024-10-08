package Main;

public class Cheese extends Food {

	public Cheese() {
		super("Cheese");
	}
	
	@Override
	public void consume() {
		System.out.println(this + " eaten");
		}

	@Override
	public double calculateCalories() {
		// TODO Auto-generated method stub
		return 200;
	}
	}