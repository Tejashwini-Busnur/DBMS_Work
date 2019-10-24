package edu.northeastern.cs5200.doas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import edu.northeastern.cs5200.models.Role;

public class RoleDao implements RoleImpl{
	
	
	  private static RoleDao instance = null;

	    public RoleDao() {
	    }

	    public static RoleDao getInstance() {
	        if (instance == null) {
	            instance = new RoleDao();
	        }
	        return instance;
	    }

	    private Connection connection = null;
	    private Statement statement = null;
	    private PreparedStatement ps = null;
	    

	    private final String assignWebsiteRole = "INSERT INTO Website_role (role_type, developer, website) VALUES (?, ?, ?)";
		@Override
		public void assignWebsiteRole(int developerId, int websiteId, int roleId) {
			try {
	            connection = edu.northeastern.cs5200.Connection.getConnection();
	            ps = connection.prepareStatement(assignWebsiteRole);
	            ps.setString(1, Role.roleIdToRole(roleId).toString());
	            ps.setInt(2, developerId);
	            ps.setInt(3, websiteId);
	            ps.executeUpdate();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			
		}

		
		private final String assignPageRole = "INSERT INTO Page_role (role_type, developer, page) VALUES (?, ?, ?)";
		@Override
		public void assignPageRole(int developerId, int pageId, int roleId) {
			try {
	            connection = edu.northeastern.cs5200.Connection.getConnection();
	            ps = connection.prepareStatement(assignPageRole);
	            ps.setString(1, Role.roleIdToRole(roleId).toString());
	            ps.setInt(2, developerId);
	            ps.setInt(3, pageId);
	            ps.executeUpdate();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			
		}
		
		private final String deleteWebsiteRole = "Delete From website_Role Where role_type=? AND developer=?AND website=?";

		@Override
		public void deleteWebsiteRole(int developerId, int websiteId, int roleId) {
			try {
	            connection = edu.northeastern.cs5200.Connection.getConnection();
	            ps = connection.prepareStatement(deleteWebsiteRole);
	            ps.setString(1, Role.roleIdToRole(roleId).toString());
	            ps.setInt(2, developerId);
	            ps.setInt(3, websiteId);
	            ps.executeUpdate();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			
		}

		
		private final String deletePageRole = "DELETE FROM page_role WHERE role_type=? AND developer=? AND page=?";
		@Override
		public void deletePageRole(int developerId, int pageId, int roleId) {
			 try {
		            connection = edu.northeastern.cs5200.Connection.getConnection();
		            ps = connection.prepareStatement(deletePageRole);
		            ps.setString(1, Role.roleIdToRole(roleId).toString().toLowerCase());
		            ps.setInt(2, developerId);
		            ps.setInt(3, pageId);
		            ps.executeUpdate();
		        } catch (ClassNotFoundException e) {
		            e.printStackTrace();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
			
		}
	    
	    

}
