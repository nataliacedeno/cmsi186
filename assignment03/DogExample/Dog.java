public class Dog {
	//private instance data
	private String name;
	private int age;
	private String gender;
	private double weight;
	private String breed;
	private String color;
	private boolean isAsleep = false;
	//constructor to create a dog
	public Dog(String pName, int pAge, String pGender, double pWeight, String pBreed, String pColor) {
		this.name = pName;
		this.age = pAge;
		this.gender = pGender;
		this.weight = pWeight;
		this.breed = pBreed;
		this.color = pColor;
	}

	public String toString() {
		return this.name + " is a " + this.color + " " + this.breed + " who is " + this.age + " years old and weighs " + this.weight + " pounds. " + this.name + " is " + this.isAsleep + ".";
	}

	public String getName() {
		return this.name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public void sleep() {
		this.isAsleep = !this.isAsleep;
	}

	public String isAsleep() {
		if (this.isAsleep) {
			return "asleep";
		} else {
			return "awake";
		}
	}

	public static String randomBreed() {
		String[] breeds = {"dachshund", "retriever", "labrador", "cocker spaniel", "beagle"};
		int randNum = (int)Math.floor(Math.random() * breeds.length);
		return breeds[randNum];
	}

	public static void main(String[] args) {
		Dog d1 = new Dog("Tinker", 1, "female", 12.2, "dachshund", "chocolate & tan");
		System.out.println("Dog d1: " + d1.toString());

		Dog d2 = new Dog("Spot", 5, "male", 45, "labrador", "black");
		System.out.println("Dog d2: " + d2.toString());

		System.out.println();
		System.out.println("Dog d1 name: " + d1.name);
	}
}