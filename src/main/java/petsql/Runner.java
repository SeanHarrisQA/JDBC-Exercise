package petsql;

public class Runner {

	public static void main(String[] args) {
		PetDAO dao = new PetDAO("jdbc:mysql://localhost:3306/petexercises", "root", "pass");
		System.out.println(dao.read());
		System.out.println(dao.create("Scruff", 3, "Black/Brown", "Schnauzer"));
		System.out.println(dao.read());
		System.out.println(dao.update("blue", "pug", "Scruff"));
		System.out.println(dao.read());
		System.out.println(dao.delete(2));
		System.out.println(dao.read());
	}
}
