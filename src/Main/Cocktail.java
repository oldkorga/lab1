package Main;

import java.util.HashMap;

public class Cocktail extends Food {

	private String drink;
	private String fruit;
	
	HashMap<String, Double> ingredientCals = new HashMap<String, Double>();
	
	
	public Cocktail(String drink, String fruit) {
		super("Cocktail");
		this.drink = drink;
		this.fruit = fruit;
		ingredientCals.put("Whiskey", 200.0);
		ingredientCals.put("Milk", 150.0);
		ingredientCals.put("Juice", 100.0);
		ingredientCals.put("Lemon", 40.0);
		ingredientCals.put("Cherry", 50.0);
		ingredientCals.put("Banana", 70.0);

	}
	
	@Override
	public boolean equals(Object obj) {
		if(super.equals(obj)) {
			if(!(obj instanceof Cocktail)) return false;
			else if(this.drink.equals(((Cocktail)obj).drink) && 
					this.fruit.equals(((Cocktail)obj).fruit)) {
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
		return "Cocktail with '" + drink + "' and '" + fruit + "'";
	}
	
	@Override
	public double calculateCalories() {
		double cals = 0;
		cals += ingredientCals.get(drink);
		cals += ingredientCals.get(fruit);
		
		return cals;
	}
	

}
