package petsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OwnerDAO {

	private final String url;
	private final String user;
	private final String password;

	public OwnerDAO(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}

	// This is the read for pet at the moment
	public List<Pet> read() {
		List<Pet> pets = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, user, password);
				Statement stmnt = conn.createStatement();
				ResultSet results = stmnt.executeQuery("SELECT * FROM pet");) {
			while (results.next()) {
				int id = results.getInt(1);
				String name = results.getString("pet_name");
				int age = results.getInt("age");
				String colour = results.getString("colour");
				String breed = results.getString("breed");
				pets.add(new Pet(id, name, age, breed, colour));
			}
			return pets;
		} catch (SQLException e) {
			System.out.println("Something bad...");
			e.printStackTrace();
		}
		return null;
	}

}
