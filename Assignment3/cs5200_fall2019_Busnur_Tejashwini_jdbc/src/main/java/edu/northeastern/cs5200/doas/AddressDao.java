package edu.northeastern.cs5200.doas;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Address;
import edu.northeastern.cs5200.models.Phone;

public class AddressDao {

	public static AddressDao instance = null;

	public AddressDao() {

	}

	public static AddressDao getInstance() {
		if (instance == null) {
			instance = new AddressDao();
		}
		return instance;
	}

	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement ps = null;

	
	private final String addAddress = "INSERT INTO address (street1, street2, city, state, zip, `primary_address`, person) VALUES(?,?,?,?,?,?,?)";

	public void addAddress(int personId, Address address) {

		try {
			ps = Connection.getConnection().prepareStatement(addAddress);
			ps.setString(1, address.getStreet1());
			ps.setString(2, address.getStreet2());
			ps.setString(3, address.getCity());
			ps.setString(4, address.getState());
			ps.setString(5, address.getZip());
			ps.setBoolean(6, address.isPrimary());
			ps.setInt(7, personId);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	private final String deletePrimaryAddress = "DELETE FROM address WHERE person = ? AND `primary_address` = ?";
	public void deletePrimaryAddress(int personId) {

		try {
			ps = Connection.getConnection().prepareStatement(deletePrimaryAddress);
			ps.setBoolean(2, true);
			ps.setInt(1, personId);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}