package Main;

import java.util.HashMap;

public class Dessert extends Food {

	private String parametr1;
	private String parametr2;
	
	
	 HashMap<String, Double> ingredientCals = new HashMap<String, Double>();
	
	
	public Dessert(String parametr1, String parametr2) {
		super("Dessert");
		this.parametr1 = parametr1;
		this.parametr2 = parametr2;
		ingredientCals.put("Coffee", 200.0);
		ingredientCals.put("Milk", 150.0);
		ingredientCals.put("Bisсuit", 100.0);
		ingredientCals.put("Lemon", 40.0);
		ingredientCals.put("Cherry", 50.0);
		ingredientCals.put("Banana", 70.0);

	}
	
	@Override
	public boolean equals(Object obj) {
		if(super.equals(obj)) {
			if(!(obj instanceof Dessert)) return false;
			else if(this.parametr1.equals(((Dessert)obj).parametr1) && 
					this.parametr2.equals(((Dessert)obj).parametr2)) {
				return true;
			}else
				return false;
		}return false;
	}
	
	@Override
	public void consume() {
		System.out.println(this + " has been consumed");
	}
	
	@Override
	public String toString() {
		return "Dessert with '" + parametr1 + "' and '" + parametr2 + "'";
	}
	
	@Override
	public double calculateCalories() {
		double cals = 0;
		cals += ingredientCals.get(parametr1);
		cals += ingredientCals.get(parametr2);
		
		return cals;
	}
	
	@Override
	public int calculateparametr() {
		int n=2;
		return n;
	}
	
	
	

}
