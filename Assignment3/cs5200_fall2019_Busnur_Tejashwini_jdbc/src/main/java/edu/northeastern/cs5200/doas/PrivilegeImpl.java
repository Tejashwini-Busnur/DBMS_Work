package edu.northeastern.cs5200.doas;

public interface PrivilegeImpl {
	

void assignWebsitePriviledge(int developerId, int websiteId, String priviledge);
//inserts into table Priviledge a record that assigns a developer whose id is developerId, the priviledge with priviledge name, to the website with websiteId
void assignPagePriviledge(int developerId, int pageId, String priviledge);
//inserts into table Priviledge a record that assigns a developer whose id is developerId, the priviledge with priviledge name, to the page with pageId
void deleteWebsitePriviledge(int developerId, int websiteId, String priviledge);
//deletes from table Priviledge a record that removes priviledge name from developerId, on websiteId
void deletePagePriviledge(int developerId, int pageId, String priviledge);
//deletes from table priviledge a record that removes priviledge name from developerId, on pageId


}
