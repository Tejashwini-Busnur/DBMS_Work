package edu.northeastern.cs5200.doas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.Website;

public class PageDao implements PageImpl {

	private static PageDao instance = null;

	public PageDao() {

	}

	public static PageDao getInstance() {
		if (instance == null) {
			instance = new PageDao();
		}
		return instance;
	}

	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement ps = null;

	private final String createPageForWebsite = "INSERT INTO Page (id, title, description, views, website) VALUES (?, ?, ?, ?, ?)";

	@Override
	public void createPageForWebsite(int websiteId, Page page) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			ps = connection.prepareStatement(createPageForWebsite);
			ps.setInt(1, page.getId());
			ps.setString(2, page.getTitle());
			ps.setString(3, page.getDescription());
			ps.setInt(4, page.getViews());
			ps.setInt(5, websiteId);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private final String findAllPages = "Select * from page";

	@Override
	public Collection<Page> findAllPages() {
		Collection<Page> pages = new ArrayList<>();
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			statement = connection.createStatement();
			ResultSet results = statement.executeQuery(findAllPages);
			while (results.next()) {
				int id = results.getInt("id");
				String title = results.getString("title");
				String description = results.getString("description");
				Date created = results.getDate("created");
				Date updated = results.getDate("updated");
				int views = results.getInt("views");
				int websiteId = results.getInt("website");
				Page page = new Page(id, title, description, created, updated, views);
				pages.add(page);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pages;
	}

	private final String findPageById = "Select * from page where id = ?";

	@Override
	public Page findPageById(int pageId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			ps = connection.prepareStatement(findPageById);
			ps.setInt(1, pageId);
			ResultSet results = ps.executeQuery();
			if (results.next()) {
				int id = results.getInt("id");
				String title = results.getString("title");
				String description = results.getString("description");
				Date created = results.getDate("created");
				Date updated = results.getDate("updated");
				int views = results.getInt("views");
				Page page = new Page(id, title, description, created, updated, views);
				return page;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private final String findPagesForWebsite = "Select * from page where website = ?";

	@Override
	public Collection<Page> findPagesForWebsite(int websiteId) {
		Collection<Page> pages = new ArrayList<>();
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			ps = connection.prepareStatement(findPagesForWebsite);
			ps.setInt(1, websiteId);
			ResultSet results = ps.executeQuery();
			while (results.next()) {
				int id = results.getInt("id");
				String title = results.getString("title");
				String description = results.getString("description");
				Date created = results.getDate("created");
				Date updated = results.getDate("updated");
				int views = results.getInt("views");
				Page page = new Page(id, title, description, created, updated, views);
				pages.add(page);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pages;

	}

	private final String updatePage = "update Page SET id = ?, title=?, description=?, views=? WHERE id=?";

	@Override
	public int updatePage(int pageId, Page page) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			ps = connection.prepareStatement(updatePage);
			ps.setInt(1, page.getId());
			ps.setString(2, page.getTitle());
			ps.setString(3, page.getDescription());
			ps.setInt(4, page.getViews());
			ps.setInt(5, pageId);
			ps.executeUpdate();
			return 1;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	private final String deletePage = "Delete from page where id = ?";

	@Override
	public int deletePage(int pageId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			ps = connection.prepareStatement(deletePage);
			ps.setInt(1, pageId);
			ps.executeUpdate();
			return 1;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
