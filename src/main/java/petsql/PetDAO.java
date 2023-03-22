package petsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PetDAO {

	private final String url;
	private final String user;
	private final String password;

	public PetDAO(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public int create(String name, int age, String colour, String breed) {
		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement stmnt = conn
						.prepareStatement("INSERT INTO pet (pet_name, age , colour, breed) VALUES (?, ?, ?, ?)");) {
			stmnt.setString(1, name);
			stmnt.setInt(2, age);
			stmnt.setString(3, colour);
			stmnt.setString(4, breed);
			return stmnt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Something bad...");
			e.printStackTrace();
		}
		return 0;
	} // create

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
	} // read

	public int update(String colour, String breed, String name) {
		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement stmnt = conn
						.prepareStatement("UPDATE pet SET colour = ?, breed = ? WHERE pet_name = ? ");) {
			stmnt.setString(1, colour);
//			stmnt.setInt(2, age);
			stmnt.setString(2, breed);
			stmnt.setString(3, name);
			return stmnt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Something bad...");
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(int id) {
		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement stmnt = conn.prepareStatement("DELETE FROM pet WHERE id = ? ");) {
			stmnt.setInt(1, id);
			return stmnt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Something bad...");
			e.printStackTrace();
		}
		return 0;
	}
}
