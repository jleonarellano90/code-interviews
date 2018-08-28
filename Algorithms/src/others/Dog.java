package others;

public class Dog {
	String name;
	int age;
	static int ageSum = 0;

	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
		ageSum += age;
	}

	public int getCurrentSum() {
		return ageSum;
	}
	
	public static void main(String[] args) {
		Dog d1 = new Dog("Dog", 2);
		System.out.println("d1 = " + d1.getCurrentSum());
		Dog d2 = new Dog("Blitz", 3);
		System.out.println("d1 = " + d1.getCurrentSum());
		System.out.println("d2 = " + d2.getCurrentSum());
	}
}