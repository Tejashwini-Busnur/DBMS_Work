package edu.northeastern.cs5200;

import java.util.Collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.northeastern.cs5200.doas.DeveloperDao;
import edu.northeastern.cs5200.doas.PageDao;
import edu.northeastern.cs5200.doas.PhoneDao;
import edu.northeastern.cs5200.doas.PrivilegeDao;
import edu.northeastern.cs5200.doas.RoleDao;
import edu.northeastern.cs5200.doas.WebsiteDao;
import edu.northeastern.cs5200.doas.WidgetDao;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.Phone;
import edu.northeastern.cs5200.models.Website;
import edu.northeastern.cs5200.models.Widget;

@SpringBootApplication
public class Cs5200Fall2019BusnurTejashwiniJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cs5200Fall2019BusnurTejashwiniJdbcApplication.class, args);
		hw_jdbc_busnur_tejashwini test = new hw_jdbc_busnur_tejashwini();
		test.create();
		//test. insertToTableWebsitePrivilege();
		//test.insertToTablePagePrivilege();
		//test.createWebsiteForDeveloper();
		//test.createPageForWebsite();
		//test.delete4();
		//testFindAllDevelopers();
		//testFindDeveloperById();
		//testFindDeveloperByUsername();
		//testfindDeveloperByCredentials();
		//testUpdateDeveloper();
		//testDeleteDeveloper();
		//testfindAllWebsites();
		//findWebsitesForDeveloper();
		//testfindWebsiteById();
		//deleteWebsite();
		//testFindAllPage();
		//testfindPageById();
		//testfindPagesForWebsite();
		//testUpdatePage();
		//testdeleteWebsitePriviledge();
		//testdeletePagePriviledge();
	}

	public static void testFindAllDevelopers() {
		DeveloperDao dao = DeveloperDao.getInstance();
		Collection<Developer> developers = dao.findAllDevelopers();
		for (Developer d : developers) {
			System.out.println(d.getFirstName());
		}

	}

	public static void testFindDeveloperById() {
		DeveloperDao dao = DeveloperDao.getInstance();
		Developer developer = dao.findDeveloperById(34);
		System.out.println(developer.getFirstName());
	}

	public static void testFindDeveloperByUsername() {
		DeveloperDao dao = DeveloperDao.getInstance();
		Developer developer = dao.findDeveloperByUsername("alice");
		System.out.println(developer.getFirstName());
	}

	public static void testfindDeveloperByCredentials() {
		DeveloperDao dao = DeveloperDao.getInstance();
		Developer developer = dao.findDeveloperByCredentials("alice", "alice");
		System.out.println(developer.getFirstName());
	}

	public static void testUpdateDeveloper() {
		DeveloperDao dao = DeveloperDao.getInstance();
		Developer developer = new Developer(23, "xxx", "xxx", "xxx", "xxx", "xxx@xxx.com", null, "xxx");
		int result = dao.updateDeveloper(23, developer);
		System.out.println(result);
	}

	public static void testDeleteDeveloper() {
		DeveloperDao dao = DeveloperDao.getInstance();
		int result = dao.deleteDeveloper(23);
		System.out.println(result);
	}
	
	public static void testfindAllWebsites() {
		WebsiteDao dao = WebsiteDao.getInstance();
		Collection<Website> Websites = dao.findAllWebsites();
		for (Website w : Websites) {
			System.out.println(w.getName());
		}

	}
	
	public static void testfindWebsiteById() {
		WebsiteDao dao = WebsiteDao.getInstance();
		Website websites = dao.findWebsiteById(123);
		System.out.println(websites.getName());

	}
	
	public static void testupdateWebsite() {
		WebsiteDao dao = WebsiteDao.getInstance();
		Website website1 = new Website(234999, "Twitter-change", "an online news and social networking service-change", 432);
		int websites = dao.updateWebsite(123,website1);
		System.out.println(websites);

	}
	
	public static void deleteWebsite() {
		WebsiteDao dao = WebsiteDao.getInstance();
		int delete = dao.deleteWebsite(234);
		System.out.println(delete);

	}
	

	public static void testFindAllPage() {
		PageDao dao = PageDao.getInstance();
		Collection<Page> pages = dao.findAllPages();
		System.out.println("hii");
		for (Page p : pages) {
			System.out.println(p.getTitle());
		}

	}

	public static void testfindWebsitesForDeveloper() {
		WebsiteDao dao = WebsiteDao.getInstance();
		Collection<Website> websites = dao.findWebsitesForDeveloper(12);
		for (Website w : websites) {
			System.out.println(w.getName());
		}
	}

	

	public static void testfindPageById() {
		PageDao dao = PageDao.getInstance();
		Page page = dao.findPageById(123);
		System.out.println(page.getTitle());

	}

	public static void testfindPagesForWebsite() {
		PageDao dao = PageDao.getInstance();
		Collection<Page> pages = dao.findPagesForWebsite(567);
		System.out.println("hii");
		for (Page p : pages) {
			System.out.println(p.getTitle());
		}

	}

	public static void testUpdatePage() {
		Page page = new Page(345, "xxxx", "xxxx", 3456);
		System.out.println("hii");
		PageDao dao = PageDao.getInstance();
		int result = dao.updatePage(345, page);
		System.out.println(result);
	}

	public static void deletePage() {
		PageDao dao = PageDao.getInstance();
		int d = dao.deletePage(123);
		System.out.println(d);

	}

	public static void testAssignWebsiteRole() {
		RoleDao roleDao = RoleDao.getInstance();
		roleDao.assignWebsiteRole(12, 123, 1);
	}

	public static void testassignPageRole() {
		RoleDao roleDao = RoleDao.getInstance();
		roleDao.assignPageRole(12, 234, 3);
	}

	public static void testdeleteWebsiteRole() {
		RoleDao roleDao = RoleDao.getInstance();
		roleDao.deleteWebsiteRole(12, 123, 1);
	}

	public static void testdeletePageRole() {
		RoleDao roleDao = RoleDao.getInstance();
		roleDao.deletePageRole(12, 234, 3);
	}

	public static void testCreateWidgetForPage() {
		WidgetDao dao = WidgetDao.getInstance();
		Widget widget1 = new Widget("head123", "heading", 0, 0, null, null, "welcome", 0);
		dao.createWidgetForPage(345, widget1);

	}

	public static void testfindWidgetById() {
		WidgetDao dao = WidgetDao.getInstance();
		Widget widget = dao.findWidgetById(679);
		System.out.println(widget.getName());

	}

	public static void findAllWidgets() {
		WidgetDao dao = WidgetDao.getInstance();
		Collection<Widget> widgets = dao.findAllWidgets();
		System.out.println("hii");
		for (Widget w : widgets) {
			System.out.println(w.getName());
		}
	}

	public static void findWidgetsForPage() {
		WidgetDao dao = WidgetDao.getInstance();
		Collection<Widget> widgets = dao.findWidgetsForPage(345);
		System.out.println("hii");
		for (Widget w : widgets) {
			System.out.println(w.getName());
		}
	}
		
    public static void testaddPhone() {
    	PhoneDao dao = PhoneDao.getInstance();
    	 Phone alice1 = new Phone("234-345-4566",false,12);
    	dao.addPhone(12,alice1);
    	
    }
    


	public static void updateWidget() {
		WidgetDao dao = WidgetDao.getInstance();
		Widget widget = new Widget(123, "head", 100, 50, null, null, "Hi!!!", 1);
		dao.updateWidget(123, widget);

}
	
	public static void testUpdateWidget() {
        Widget widget = new Widget(345, "head345-change", 100, 50, null, null, "Hi!!!", 1);
        WidgetDao dao = WidgetDao.getInstance();
        PageDao pageDao = PageDao.getInstance();
        Page page = pageDao.findPageById(123);
        widget.setPage(page);
		int result = dao.updateWidget(345, widget);
    }
	
	public static void deleteWidget() {
		WidgetDao dao = WidgetDao.getInstance();
		dao.deleteWidget(123);

}
	
	public static void testdeleteWebsitePriviledge() {
		PrivilegeDao dao = PrivilegeDao.getInstance();
		dao.deleteWebsitePriviledge(12, 123, "create");
	}
	
	public static void testdeletePagePriviledge() {
		PrivilegeDao dao = PrivilegeDao.getInstance();
		dao.deletePagePriviledge(12, 123, "create");
	}
	
	
}
