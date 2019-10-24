package edu.northeastern.cs5200;

import edu.northeastern.cs5200.doas.RoleDao;

public class testRole  {
	
	 RoleDao roleDao = RoleDao.getInstance();

	    
	    public void testAssignWebsiteRole() {
	        roleDao.assignWebsiteRole(12,123,1);
	    }
	
	

}
