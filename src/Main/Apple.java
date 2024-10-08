package Main;

public class Apple extends Food {
	
	public Apple(String name) {
		super("Apple");
		this.size = name;
	}
	
	private String size;
	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}


	@Override
	public String toString() {
		return "Apple of size '" + size + "'";
	}


	@Override
	public void consume() {
		System.out.println(this + " eaten");
	}

	@Override
	public boolean equals(Object obj) {
		if(super.equals(obj)) {
			if(obj instanceof Apple && (size.equals(((Apple)obj).size))) {
				return true;
			}else return false;
		}else return false;
	}
	@Override
	public double calculateCalories() {
		if(size.equals("Small")) {
			return 200;
		}else if (size.equals("Medium")) {
			return 300;
		}else if (size.equals("Large")) {
			return 400;
		}else return 300;
	}

}
