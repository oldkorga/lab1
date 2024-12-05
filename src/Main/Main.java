package Main;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws
	InvocationTargetException, IllegalAccessException, InstantiationException {
		Food[] breakfast = new Food[20];
		
		
		String[] productToCount = new String[3];
		int productCount = 0;
		
		int amount = 0;
		boolean caloriesNeeded = false;
		boolean sortingNeeded = false;
		
		//forming breakfast
			for(int i = 0; i < args.length; i++) {
				String[] parts = args[i].split("/");
				//checking for flags
				if(parts[0].startsWith("-")) {
					if(parts[0].endsWith("calories")) {
						caloriesNeeded = true;
						continue;
					}else
					if(parts[0].endsWith("find")) {
						i++;
						if(i < args.length && !(args[i].split("/")[0].startsWith("-")))
							productToCount = args[i].split("/");
						else System.out.println("No product to look for");
						continue;
					}else
					if(parts[0].endsWith("sort")) {
						sortingNeeded = true;
						continue;
					}else continue;
				}
				try {
					
					Class myClass = Class.forName("Main." + parts[0]);
				
					if(parts.length == 1) {
						Constructor constructor = myClass.getConstructor();
						breakfast[amount++] = (Food)constructor.newInstance();
					}else
					if(parts.length == 2) {
						Constructor constructor = myClass.getConstructor(String.class);
						breakfast[amount++] = (Food)constructor.newInstance(parts[1]);
					}else
					if(parts.length == 3) {
						Constructor constructor = myClass.getConstructor(String.class, String.class);
						breakfast[amount++] = (Food)constructor.newInstance(parts[1], parts[2]);
					}
				}
				catch(ClassNotFoundException e){
					System.out.println("Product '" + parts[0] + "' cannot be added");
				}
				catch(NoSuchMethodException e) {
					System.out.println("Product '" + parts[0] + "' cannot be added");
				}
			}

		//sorting(if needed)
		if(sortingNeeded) {Arrays.sort(breakfast, new Comparator() {
			public int compare(Object f1, Object f2) {
				if(f1 == null) return 1;
				if(f2 == null) return -1;
				if (((Food)f1).calculateparametr()	 > ((Food)f2).calculateparametr()) {
					return -1;
				}else if(((Food)f1).calculateparametr() < (((Food)f2).calculateparametr())) {
					return 1;
				}else return 0;
				};});
		};
		//counting(if needed)
		if(productToCount[0] != null) {try {
			
			Class myClass = Class.forName("Main." + productToCount[0]);
			
			Food[] mealToFind = new Food[1];
			
			if(productToCount.length == 1) {
				Constructor constructor = myClass.getConstructor();
				mealToFind[0] = (Food)constructor.newInstance();
			}else
			if(productToCount.length == 2) {
				Constructor constructor = myClass.getConstructor(String.class);
				mealToFind[0] = (Food)constructor.newInstance(productToCount[1]);
			}else
			if(productToCount.length == 3) {
				Constructor constructor = myClass.getConstructor(String.class, String.class);
				mealToFind[0] = (Food)constructor.newInstance(productToCount[1], productToCount[2]);
			}
			
			for(Food meal: breakfast) {
				if(meal != null) {
					if(meal.equals(mealToFind[0])) {
						productCount++;
					}
				}else break;
			}
			
			System.out.println("Found " + productCount + " of " + mealToFind[0]);
			
		}
		catch(ClassNotFoundException e){
			System.out.println("Product '" + productToCount[0] + "' cannot be found");
		}
		catch(NoSuchMethodException e) {
			System.out.println("Product '" + productToCount[0] + "' cannot be found");
		}
			
		}
		
		//consuming
		for(Food meal: breakfast) {
			if(meal != null) {
				meal.consume();
			}
			else break;
		}
		System.out.println();
		
		//counting calories(if needed)
		if(caloriesNeeded) {
			double cals = 0;
			for(Food meal: breakfast) {
				if(meal != null) {
					System.out.println(meal + " " + meal.calculateCalories());
					cals += meal.calculateCalories();
				}
			}
			System.out.println(cals);
		}
		
	}

}
