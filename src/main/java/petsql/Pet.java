package petsql;

public class Pet {
	private final int id;
	private String name;
	private String breed;
	private String colour;
	private int age;

	public Pet(int id, String name, int age, String breed, String colour) {
		super();
		this.id = id;
		this.age = age;
		this.setName(name);
		this.breed = breed;
		this.colour = colour;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "\nPet [ID: " + this.id + "name=" + this.name + ", breed=" + this.breed + ", colour=" + this.colour
				+ ", age=" + this.age + "]";
	}

}
