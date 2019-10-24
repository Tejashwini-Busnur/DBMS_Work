package edu.northeastern.cs5200.doas;

import java.util.Collection;

import edu.northeastern.cs5200.models.Website;

public interface WebsiteImpl {
	
	void createWebsiteForDeveloper(int developerId, Website website);
	//inserts properties in website instance parameter into the Website table. The website's developerId foreign key refer to Developer table primary key id whose value is equal to the developerId parameter. You can use the owner's user id as the foreign key
	Collection<Website> findAllWebsites();
	//returns all records from Website table as a Collection of Website instances
	Collection<Website> findWebsitesForDeveloper(int developerId);
	//returns all records from Website table as a Collection of Website instances whose developerId is equal to the developerId parameter
	Website findWebsiteById(int websiteId);
	//returns a record from Website table whose id field is equal to the websiteId parameter
	int updateWebsite(int websiteId, Website website);
	//updates record in Website table whose id field is equal to websiteId parameter. New record field values are set to the values in the website instance parameter
	int deleteWebsite(int websiteId);
	//deletes record from Website table whose id field is equal to websiteId parameter


}
