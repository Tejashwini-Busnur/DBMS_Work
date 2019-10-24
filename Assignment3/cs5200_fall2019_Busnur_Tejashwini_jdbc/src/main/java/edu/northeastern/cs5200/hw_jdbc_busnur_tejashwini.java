package edu.northeastern.cs5200;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.mysql.cj.protocol.Resultset;

import edu.northeastern.cs5200.doas.AddressDao;
import edu.northeastern.cs5200.doas.DeveloperDao;
import edu.northeastern.cs5200.doas.PageDao;
import edu.northeastern.cs5200.doas.PhoneDao;
import edu.northeastern.cs5200.doas.PrivilegeDao;
import edu.northeastern.cs5200.doas.RoleDao;
import edu.northeastern.cs5200.doas.WebsiteDao;
import edu.northeastern.cs5200.doas.WidgetDao;
import edu.northeastern.cs5200.models.Address;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.Phone;
import edu.northeastern.cs5200.models.Website;
import edu.northeastern.cs5200.models.Widget;

public class hw_jdbc_busnur_tejashwini {

	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement ps = null;

	public void create() {

		DeveloperDao dao = DeveloperDao.getInstance();
		Developer alice = new Developer(12, "Alice", "Wonder", "alice", "alice", "alice@wonder.com", null, "4321rewq");
		dao.createDeveloper(alice);
		Developer bob = new Developer(23, "Bob", "Marley", "bob", "bob", "bob@marley.com", null, "5432trew");
		dao.createDeveloper(bob);
		Developer charlie = new Developer(34, "Charlie", "Garcia", "charlie", "charlie", "chuch@garcia.com", null,
				"6543erty");
		dao.createDeveloper(charlie);

	}

	public void createWebsiteForDeveloper() {
		WebsiteDao dao = WebsiteDao.getInstance();
		Website website1 = new Website(123, "Facebook", "an online social media and social networking service", 1234234);
		Website website2 = new Website(234, "Twitter", "an online news and social networking service", 4321543);
		Website website3 = new Website(345, "Wikipedia", "a free online encyclopedia", 3456654);	
		Website website4 = new Website(456, "CNN", "an American basic cable and satellite television news channel",
				6543345);
		Website website5 = new Website(567, "CNET",
				"an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics",
				5433455);
		Website website6 = new Website(678, "Gizmodo",
				"a design, technology, science and science fiction website that also writes articles on politics",
				4322345);
		dao.createWebsiteForDeveloper(12, website1);
		dao.createWebsiteForDeveloper(23, website2);
		dao.createWebsiteForDeveloper(34, website3);
		dao.createWebsiteForDeveloper(12, website4);
		dao.createWebsiteForDeveloper(23, website5);
		dao.createWebsiteForDeveloper(34, website6);

	}

	public void createPageForWebsite() {
		PageDao pageDao = PageDao.getInstance();

		Page home = new Page(123, "Home", "Landing page", 123434);
		pageDao.createPageForWebsite(567, home);
		Page about = new Page(234, "About", "Website description", 234545);
		pageDao.createPageForWebsite(678, about);
		Page contact = new Page(345, "Contact", "Addresses, phones, and contact info", 345656);
		pageDao.createPageForWebsite(345, contact);
		Page preferences = new Page(456, "Preferences", "Where users can configure their preferences", 456776);
		pageDao.createPageForWebsite(456, preferences);
		Page profile = new Page(567, "Profile", "Users can configure their personal infomation", 567878);
		pageDao.createPageForWebsite(567, profile);

	}

	// phone and addresses

	public void addPhoneNumbers() {

		Phone alice1 = new Phone("234-345-4566", false, 12);
		Phone alice2 = new Phone("123-234-3456", true, 12);
		Phone bob1 = new Phone("345-456-5677", true, 23);
		Phone charlie1 = new Phone("321-456-5677", true, 34);
		Phone charlie2 = new Phone("432-432-5433", false, 34);
		Phone charlie3 = new Phone("543-543-6544", false, 34);

		PhoneDao dao = new PhoneDao();
		dao.addPhone(12, alice1);
		dao.addPhone(12, alice2);
		dao.addPhone(23, bob1);
		dao.addPhone(34, charlie1);
		dao.addPhone(34, charlie2);
		dao.addPhone(34, charlie3);

	}

	public void addAddresses() {

		Address alice1 = new Address("123 Adam St.", "", "Alton", "", "01234", true, 12);
		Address alice2 = new Address("234 Birch St", "", "Boston", "", "02345", false, 12);
		Address bob1 = new Address("345 Charles St.", "", "Chelms", "", "03455", true, 23);
		Address bob2 = new Address("456 Down St.", "", "Dalton", "", "04566", false, 23);
		Address bob3 = new Address("543 East St.", "", "Everett", "", "01112", false, 23);
		Address charlie1 = new Address("654 Frank St.", "", "Foulton", "", "04322", true, 34);

		AddressDao addressDao = new AddressDao();
		addressDao.addAddress(12, alice1);
		addressDao.addAddress(12, alice2);
		addressDao.addAddress(23, bob1);
		addressDao.addAddress(23, bob2);
		addressDao.addAddress(23, bob3);
		addressDao.addAddress(34, charlie1);

	}
	
	public void insertToTableWebsitePrivilege() {
		PrivilegeDao dao = PrivilegeDao.getInstance();
		dao.assignWebsitePriviledge(12, 123, "create");
	}
	
	public void insertToTablePagePrivilege() {
		PrivilegeDao dao = PrivilegeDao.getInstance();
		dao.assignPagePriviledge(12, 123, "create");
	}

	public void update() {

		DeveloperDao developerDao = DeveloperDao.getInstance();
		Developer charlie = developerDao.findDeveloperByUsername("charlie");
		Collection<Phone> phones = charlie.getPhone_numbers();
		PhoneDao dao = new PhoneDao();
		Phone charliePhone = new Phone("333-444-5555", true, charlie.getId());
		charlie.setPhone_numbers(new ArrayList<>());
		if (phones.isEmpty()) {
			dao.addPhone(12, charliePhone);
		} else {
			for (Phone phone : phones) {
				if (phone.getIsPrimary()) {
					phone.setPhone("333-444-5555");
				}
				dao.addPhone(12, charliePhone);
			}
		}
		developerDao.updateDeveloper(charlie.getId(), charlie);
	}

	public void update2() {

		WidgetDao widgetDao = WidgetDao.getInstance();
		int pageId = findPage("head345-change");
		Collection<Widget> widgets = widgetDao.findWidgetsForPage(pageId);
		for (Widget widget : widgets) {
			widget.setOrder(3);
			widgetDao.updateWidget(widget.getId(), widget);
		}
	}

	private final String findPage = "Select * from widget where name = ?";

	private int findPage(String widgetName) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			ps = connection.prepareStatement(findPage);
			ps.setString(1, widgetName);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				return resultSet.getInt("page");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void update3() {
		PageDao pageDao = PageDao.getInstance();
		Collection<Page> pages = pageDao.findPagesForWebsite(567);
		for (Page page : pages) {
			page.setTitle("CNET - " + page.getTitle());
			pageDao.updatePage(page.getId(), page);
		}
	}

	public void update4() {

		DeveloperDao developerDao = DeveloperDao.getInstance();
		RoleDao roleDao = RoleDao.getInstance();

		int pageId = 123;
		Developer charlie = developerDao.findDeveloperByUsername("charlie");
		Developer bob = developerDao.findDeveloperByUsername("bob");
		roleDao.deletePageRole(charlie.getId(), pageId, 5);
		roleDao.deletePageRole(bob.getId(), pageId, 4);
		roleDao.assignPageRole(charlie.getId(), pageId, 4);
		roleDao.assignPageRole(bob.getId(), pageId, 5);
	}

	public void delete1() {

		DeveloperDao developerDao = DeveloperDao.getInstance();
		Developer developerObj;
		developerObj = developerDao.findDeveloperByUsername("alice");
		int id = developerObj.getId();
		AddressDao addressDao = new AddressDao();
		addressDao.deletePrimaryAddress(id);

	}

	private final String findMaxWidget = "(Select * from widget\r\n" + "WHERE order_type IN \r\n" + "(SELECT * from\r\n"
			+ "(SELECT max(order_type) from widget) temp))";

	public void delete2() {
		try {

			connection = edu.northeastern.cs5200.Connection.getConnection();
			ps = connection.prepareStatement(findMaxWidget);
			ResultSet results = ps.executeQuery();
			while (results.next()) {
				int id = results.getInt("id");
				System.out.print(id);
				WidgetDao widgetDao = new WidgetDao();
				widgetDao.deleteWidget(id);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private final String findlastupdated = "SELECT * FROM Page WHERE page.id=(SELECT website.id FROM Website WHERE name=?) ORDER BY updated DESC LIMIT 1";

	public void delete3() {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			ps = connection.prepareStatement(findlastupdated);
			ps.setString(1, "Wikipedia");
			ResultSet results = ps.executeQuery();

			while (results.next()) {
				int id = results.getInt("id");
				System.out.print(id);
				PageDao pageDao = new PageDao();
				pageDao.deletePage(id);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void delete4() {
		 WebsiteDao websiteDao = WebsiteDao.getInstance();
		 Website website = websiteDao.findWebsiteByName("CNET");
		 websiteDao.deleteWebsite(website.getId());
		 }
}
