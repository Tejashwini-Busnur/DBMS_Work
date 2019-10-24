package edu.northeastern.cs5200.doas;

import edu.northeastern.cs5200.models.Developer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class DeveloperDao implements DeveloperImpl {

	private static DeveloperDao instance = null;

	private DeveloperDao() {

	}

	public static DeveloperDao getInstance() {
		if (instance == null) {
			instance = new DeveloperDao();
		}
		return instance;
	}

	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement ps = null;

	private final String FIND_PERSON_BY_ID = "SELECT * FROM `Person` WHERE id=?";

	private final String createPerson = "INSERT INTO Person (id, username, password, first_name, last_name, email, date_of_birth) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private final String createDeveloper = "INSERT INTO `Developer` (`person`, `developer_Key`) VALUES (?, ?)";

	public void createDeveloper(Developer developer) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			ps = connection.prepareStatement(createPerson);
			ps.setInt(1, developer.getId());
			ps.setString(2, developer.getUsername());
			ps.setString(3, developer.getPassword());
			ps.setString(4, developer.getFirstName());
			ps.setString(5, developer.getLastName());
			ps.setString(6, developer.getEmail());
			ps.setDate(7, null);
			ps.executeUpdate();
			ps = connection.prepareStatement(createDeveloper);
			ps.setInt(1, developer.getId());
			ps.setString(2, developer.getDeveloperKey());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private final String findAllDevelopers = "SELECT * FROM developer, person where developer.person = person.id";

	public Collection<Developer> findAllDevelopers() {
		Collection<Developer> developers = new ArrayList<Developer>();
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			statement = connection.createStatement();
			ResultSet results = statement.executeQuery(findAllDevelopers);
			while (results.next()) {
				int developerId = results.getInt("id");
				String firstName = results.getString("first_name");
				String lastName = results.getString("last_name");
				String userName = results.getString("username");
				String password = results.getString("password");
				String email = results.getString("email");
				Date dob = results.getDate("date_of_birth");
				String developerKey = results.getString("developer_key");
				Developer developer = new Developer(developerId, firstName, lastName, userName, password, email, dob,
						developerKey);
				developers.add(developer);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return developers;
	}

	private final String findDeveloperById = "SELECT * FROM developer, person where person.id = ?";

	public Developer findDeveloperById(int developerId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			ps = connection.prepareStatement(findDeveloperById);
			ps.setInt(1, developerId);
			ResultSet result = ps.executeQuery();
			if (result.next()) {
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				String userName = result.getString("username");
				String password = result.getString("password");
				String email = result.getString("email");
				Date dob = result.getDate("date_of_birth");
				String developerKey = result.getString("developer_key");
				Developer developer = new Developer(developerId, firstName, lastName, userName, password, email, dob,
						developerKey);
				return developer;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private final String findDeveloperByUsername = "select * from Person p JOIN Developer d ON p.id = d.person WHERE username=?";

	@Override
	public Developer findDeveloperByUsername(String username) {

		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			ps = connection.prepareStatement(findDeveloperByUsername);
			ps.setString(1, username);
			ResultSet results = ps.executeQuery();
			if (results.next()) {
				int id = results.getInt("id");
				String firstName = results.getString("first_name");
				String lastName = results.getString("last_name");
				String password = results.getString("password");
				String email = results.getString("email");
				Date dob = results.getDate("date_of_birth");
				String developerKey = results.getString("developer_Key");
				Developer developer = new Developer(id, firstName, lastName, username, password, email, dob,
						developerKey);
				return developer;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private final String findDeveloperByCredentials = "select * from person p, developer d where p.id = d.person AND p.username = ? and p.password = ?";

	@Override
	public Developer findDeveloperByCredentials(String username, String password) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			ps = connection.prepareStatement(findDeveloperByCredentials);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet results = ps.executeQuery();
			if (results.next()) {
				int id = results.getInt("id");
				String firstName = results.getString("first_name");
				String lastName = results.getString("last_name");
				String email = results.getString("email");
				Date dob = results.getDate("date_of_birth");
				String developerKey = results.getString("developer_Key");
				Developer developer = new Developer(id, firstName, lastName, username, password, email, dob,
						developerKey);
				return developer;
			}
		} catch (ClassNotFoundException e) {		
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private final String updatePersonTable = "update Person SET first_name=?, last_name=?, username=?, password=?, email=?, date_of_birth=? WHERE id=?";
	private final String updateDeveloperTable = "update Developer SET developer_Key=? WHERE person=?";
	@Override
	public int updateDeveloper(int developerId, Developer developer) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			ps = connection.prepareStatement(updatePersonTable);
			ps.setString(1, developer.getFirstName());
			ps.setString(2, developer.getLastName());
			ps.setString(3, developer.getUsername());
			ps.setString(4, developer.getPassword());
			ps.setString(5, developer.getEmail());
			ps.setDate(6, null);
			ps.setInt(7, developerId);
			ps.executeUpdate();
			ps = connection.prepareStatement(updateDeveloperTable);
			ps.setString(1, developer.getDeveloperKey());
			ps.setInt(2, developerId);
			ps.executeUpdate();
			return 1;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	private final String deletePerson = "DELETE FROM Person WHERE id=?;";
	private final String deleteDeveloper = "DELETE FROM Developer WHERE person=?";
	@Override
	public int deleteDeveloper(int developerId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			ps = connection.prepareStatement(deletePerson);
			ps.setInt(1, developerId);
			ps.executeUpdate();
			ps = connection.prepareStatement(deleteDeveloper);
			ps.setInt(1, developerId);
			ps.executeUpdate();
			return 1;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}