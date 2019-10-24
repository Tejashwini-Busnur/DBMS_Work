package edu.northeastern.cs5200.doas;

import java.sql.*;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Phone;

public class PhoneDao implements PhoneImpl {

	public static PhoneDao instance = null;

	public PhoneDao() {

	}

	public static PhoneDao getInstance() {
		if (instance == null) {
			instance = new PhoneDao();
		}
		return instance;
	}

	private PreparedStatement ps = null;

	private final String UPDATE_PHONE = "UPDATE phone SET phone = ? WHERE person_id = ? AND `primary` = ?";
	private final String DELETE_PHONE = "DELETE FROM phone WHERE person_id = ? AND `primary` = ?";

	private final String addPhone = "INSERT INTO phone (phone, `primary_number`, person) VALUES(?,?,?)";

	@Override
	public void addPhone(int personId, Phone phone) {

		try {
			ps = Connection.getConnection().prepareStatement(addPhone);
			ps.setString(1, phone.getPhone());
			ps.setBoolean(2, phone.isPrimary());
			ps.setInt(3, personId);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatePrimaryPhone(int personId, Phone phone) {

		try {
			ps = Connection.getConnection().prepareStatement(UPDATE_PHONE);
			ps.setString(1, phone.getPhone());
			ps.setBoolean(2, true);
			ps.setInt(3, personId);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletePrimaryPhone(int personId, Phone phone) {

		try {

			ps = Connection.getConnection().prepareStatement(DELETE_PHONE);
			ps.setBoolean(1, true);
			ps.setInt(2, personId);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}