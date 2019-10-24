package edu.northeastern.cs5200.doas;

import java.util.Collection;

import edu.northeastern.cs5200.models.Page;

public interface PageImpl {
	

void createPageForWebsite(int websiteId, Page page);
//inserts properties in page instance parameter into the Page table. The page's websiteId foreign key refer to Website table primary key id whose value is equal to the websiteId parameter
Collection<Page> findAllPages();
//returns all records from Page table as a Collection of Page instances
Page findPageById(int pageId);
//returns a record from Page table whose id field is equal to the pageId parameter
Collection<Page> findPagesForWebsite(int websiteId);
//returns all records from Page table as a Collection of Page instances whose websiteId is equal to the websiteId parameter
int updatePage(int pageId, Page page);
//updates record in Page table whose id field is equal to pageId parameter. New record field values are set to the values in the page instance parameter
int deletePage(int pageId);
//deletes record from Page table whose id field is equal to pageId parameter

}
