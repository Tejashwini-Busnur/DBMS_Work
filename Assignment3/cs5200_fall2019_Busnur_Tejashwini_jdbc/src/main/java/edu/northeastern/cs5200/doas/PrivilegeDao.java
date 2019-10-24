package edu.northeastern.cs5200.doas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PrivilegeDao implements PrivilegeImpl {
	
	  private static PrivilegeDao instance = null;

	    public PrivilegeDao() {
	    }

	    public static PrivilegeDao getInstance() {
	        if (instance == null) {
	            instance = new PrivilegeDao();
	        }
	        return instance;
	    }

	    private Connection connection = null;
	    private PreparedStatement ps = null;

	private final String assignWebsitePriviledge = "INSERT INTO website_privilege (privilege, developer, website) VALUES (?, ?, ?)";
	@Override
	public void assignWebsitePriviledge(int developerId, int websiteId, String priviledge) {
			try {
				connection = edu.northeastern.cs5200.Connection.getConnection();
	            ps = connection.prepareStatement(assignWebsitePriviledge);
	            ps.setString(1, priviledge);
	            ps.setInt(2, developerId);
	            ps.setInt(3, websiteId);
	            ps.executeUpdate();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}


	private final String assignPagePriviledge = "INSERT INTO page_privilege (privilege, developer, page) VALUES (?, ?, ?)";
	@Override
	public void assignPagePriviledge(int developerId, int pageId, String priviledge) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
            ps = connection.prepareStatement(assignPagePriviledge);
            ps.setString(1, priviledge);
            ps.setInt(2, developerId);
            ps.setInt(3, pageId);
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	private final String deleteWebsitePriviledge = "Delete From website_privilege where privilege=? AND developer=? AND website=?";
	@Override
	public void deleteWebsitePriviledge(int developerId, int websiteId, String priviledge) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
            ps = connection.prepareStatement(deleteWebsitePriviledge);
            ps.setString(1, priviledge);
            ps.setInt(2, developerId);
            ps.setInt(3, websiteId);
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	private final String deletePagePriviledge = "DELETE FROM page_privilege WHERE page=? AND developer=? AND privilege=?";
	@Override
	public void deletePagePriviledge(int developerId, int pageId, String priviledge) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
            ps = connection.prepareStatement(deletePagePriviledge);
            ps.setInt(1, pageId);
            ps.setInt(2, developerId);
            ps.setString(3, priviledge);
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

}
