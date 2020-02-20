public class DogPack {
	//private instance data
	private int count;
	private String name;
	private int age;
	private String gender;
	private double weight;
	private String breed;
	private String color;
	private Dog[] dp = null;

	//constructor
	public DogPack (int pCount, String pName, int pAge, String pGender, double pWeight, String pBreed, String pColor) {
		this.dp = new Dog[pCount];
		for(int i=0; i<pCount; i++) {
			dp[i] = new Dog("Tinker", 1, "female", 12.2, "dachshund", "chocolate & tan");
		}
	}

	public String toString() {
		String result = "";
		for (int i = 0; i<pCount; i++) {
			dp[i].toString();
			result += dp[i].toString() + "\n";
		}
		return result;
	}
	public void sleep() {
		for (int i=0;i<dp.length;i++) {
			dp[i].sleep();
		}
	}

	public static void main(String[] args) {
		System.out.println();
		System.out.println("Creating a DogPack of 10 Tinkers.");
		DogPack myDogPack = new DogPack(10, "Tinker", 1, "female", 12.2, "dachshund", "chocolate & tan");
		System.out.println(myDogPack.toString());
		System.out.println();
		System.out.println();
		System.out.println("Setting DogPack to sleep.");
		myDogPack.sleep();
		System.out.println(myDogPack.toString());

	}
}