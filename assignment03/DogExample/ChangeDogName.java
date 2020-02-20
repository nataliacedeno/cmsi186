public class ChangeDogName {
	public static void main(String[] args) {
		System.out.println("Hello from ChangeDogName");
		Dog myDog = new Dog("Tinker", 1, "female", 12.2, "dachshund", "chocolate & tan");
		System.out.println("My dog: " + myDog.toString());

		//System.out.println("my dog name: " + myDog.name); //will produce error bc name is private
		System.out.println("My dog's name: " + myDog.getName());

		System.out.println();
		System.out.println("Changing name to: " + args[0]);
		myDog.setName(args[0]);
		System.out.println(myDog.toString());

		System.out.println();
		System.out.println();
		System.out.println("Is my dog asleep?");
		System.out.println(myDog.isAsleep());
		System.out.println("Change sleep");
		myDog.sleep();
		System.out.println(myDog.isAsleep());

		System.out.println();
		System.out.println();
		System.out.println("Generate a random breed");
		System.out.println(Dog.randomBreed());
		System.out.println();

	}
}