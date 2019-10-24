package edu.northeastern.cs5200.doas;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Website;

public class WebsiteDao implements WebsiteImpl {

	private static WebsiteDao instance = null;

	private WebsiteDao() {

	}

	public static WebsiteDao getInstance() {
		if (instance == null) {
			instance = new WebsiteDao();
		}
		return instance;
	}

	private final String createWebsiteForDeveloper = "insert into website (id, developer, name, description, visits)"
			+ "values (?, ?, ?, ?, ?)";

	@Override
	public void createWebsiteForDeveloper(int developerId, Website website) {
		java.sql.Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = Connection.getConnection();
			ps = connection.prepareStatement(createWebsiteForDeveloper);
			ps.setInt(1, website.getId());
			ps.setInt(2, developerId);
			ps.setString(3, website.getName());
			ps.setString(4, website.getDescription());
			ps.setInt(5, website.getVisits());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private final String findAllWebsites = "SELECT * FROM website";

	@Override
	public Collection<Website> findAllWebsites() {
		java.sql.Connection connection = null;
		Collection<Website> websites = new ArrayList<Website>();
		Statement statement = null;
		ResultSet results = null;
		try {
			connection = Connection.getConnection();
			statement = connection.createStatement();
			results = statement.executeQuery(findAllWebsites);
			while (results.next()) {
				int websiteId = results.getInt("id");
				String name = results.getString("name");
				String description = results.getString("description");
				Date created = results.getDate("created");
				Date updated = results.getDate("updated");
				int visits = results.getInt("visits");
				Website website = new Website(websiteId, name, description, created, updated, visits);
				websites.add(website);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return websites;
	}

	private final String findWebsitesForDeveloper = "SELECT * FROM website, developer where website.developer = ?";

	@Override
	public Collection<Website> findWebsitesForDeveloper(int developerId) {
		java.sql.Connection connection = null;
		Collection<Website> websites = new ArrayList<Website>();
		PreparedStatement ps = null;
		ResultSet results = null;
		try {
			connection = Connection.getConnection();
			ps = connection.prepareStatement(findWebsitesForDeveloper);
			ps.setInt(1, developerId);
			results = ps.executeQuery();
			while (results.next()) {
				int websiteId = results.getInt("id");
				String name = results.getString("name");
				String description = results.getString("description");
				Date created = results.getDate("created");
				Date updated = results.getDate("updated");
				int visits = results.getInt("visits");
				Website website = new Website(websiteId, name, description, created, updated, visits);
				websites.add(website);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return websites;
	}

	private final String findWebsiteById = "SELECT * FROM website where website.id = ?";

	@Override
	public Website findWebsiteById(int websiteId) {
		java.sql.Connection connection = null;
		Website website = null;
		PreparedStatement ps = null;
		ResultSet results = null;
		try {
			connection = Connection.getConnection();
			ps = connection.prepareStatement(findWebsiteById);
			ps.setInt(1, websiteId);
			results = ps.executeQuery();
			while (results.next()) {
				int id = results.getInt("id");
				String name = results.getString("name");
				String description = results.getString("description");
				Date created = results.getDate("created");
				Date updated = results.getDate("updated");
				int visits = results.getInt("visits");
				website = new Website(id, name, description, created, updated, visits);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return website;
	}

	private final String updateWebsite = "update website SET  id = ?,name=?, description=?, visits=? WHERE id=?";

	@Override
	public int updateWebsite(int websiteId, Website website) {
		java.sql.Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = Connection.getConnection();
			ps = connection.prepareStatement(updateWebsite);
			ps.setInt(1, website.getId());
			ps.setString(2, website.getName());
			ps.setString(3, website.getDescription());
			ps.setInt(4, website.getVisits());
			ps.setInt(5, websiteId);
			ps.executeUpdate();
			return 1;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	private final String deleteWebsite = "DELETE FROM website WHERE id=?";

	@Override
	public int deleteWebsite(int websiteId) {
		java.sql.Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = Connection.getConnection();
			ps = connection.prepareStatement(deleteWebsite);
			ps.setInt(1, websiteId);
			ps.executeUpdate();
			return 1;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	private final String findWebsiteByName = "SELECT * FROM website where website.name = ?";

	public Website findWebsiteByName(String websiteName) {
		java.sql.Connection connection = null;
		Website website = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			connection = Connection.getConnection();
			statement = connection.prepareStatement(findWebsiteByName);
			statement.setString(1, websiteName);
			results = statement.executeQuery();
			while (results.next()) {
				int id = results.getInt("id");
				String name = results.getString("name");
				String description = results.getString("description");
				Date created = results.getDate("created");
				Date updated = results.getDate("updated");
				int visits = results.getInt("visits");
				website = new Website(id, name, description, created, updated, visits);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return website;
	}

}
