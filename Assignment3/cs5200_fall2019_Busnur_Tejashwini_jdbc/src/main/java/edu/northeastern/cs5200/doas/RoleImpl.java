package edu.northeastern.cs5200.doas;

public interface RoleImpl {
	
	void assignWebsiteRole(int developerId, int websiteId, int roleId);
	//inserts into table Role a record that assigns a developer whose id is developerId, the role with roleId, to the website with websiteId
	void assignPageRole(int developerId, int pageId, int roleId);
	//inserts into table Role a record that assigns a developer whose id is developerId, the role with roleId, to the page with pageId
	void deleteWebsiteRole(int developerId, int websiteId, int roleId);
	//deletes from table Role a record that removes roleId from developerId, on websiteId
	void deletePageRole(int developerId, int pageId, int roleId);
	//deletes from table Role a record that removes roleId from developerId, on pageId

	

}
