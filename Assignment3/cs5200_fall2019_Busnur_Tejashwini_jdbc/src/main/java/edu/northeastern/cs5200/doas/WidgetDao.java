package edu.northeastern.cs5200.doas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.models.HeadingWidget;
import edu.northeastern.cs5200.models.HtmlWidget;
import edu.northeastern.cs5200.models.ImageWidget;
import edu.northeastern.cs5200.models.Widget;
import edu.northeastern.cs5200.models.YouTubeWidget;

public class WidgetDao implements WidgetImpl {

	private static WidgetDao widgetInstance = null;

	public WidgetDao() {

	}

	public static WidgetDao getInstance() {
		if (widgetInstance == null) {
			widgetInstance = new WidgetDao();
		}
		return widgetInstance;
	}

	private Connection connection = null;
	private PreparedStatement ps = null;

	private final String createWidgetForPage = "INSERT INTO widget (name,dtype,text,order_type,width,height,url,page)"
			+ "	 SELECT ?, ?, ?, ?, ?, ?, ?, ?" + "	 FROM page" + "	 WHERE id = ?";

	@Override
	public void createWidgetForPage(int pageId, Widget widget) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			ps = connection.prepareStatement(createWidgetForPage);
			ps.setString(1, widget.getName());
			ps.setString(2, widget.getdType());
			ps.setString(3, widget.getText());
			ps.setInt(4, widget.getOrder());
			ps.setInt(5, widget.getWidth());
			ps.setInt(6, widget.getHeight());
			if (widget.getdType().equals("youtube")) {
				YouTubeWidget url = (YouTubeWidget) widget;
				ps.setString(7, url.getUrl());
			} else if (widget.getdType().equals("image")) {
				ImageWidget image = (ImageWidget) widget;
				ps.setString(7, image.getSrc());
			} else {
				ps.setString(7, null);
			}
			ps.setInt(8, pageId);
			ps.setInt(9, pageId);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private final String findAllWidgetsSql = "Select * from widget";

	@Override
	public Collection<Widget> findAllWidgets() {
		Collection<Widget> widgets = new ArrayList<>();

		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery(findAllWidgetsSql);
			while (results.next()) {
				int id = results.getInt("id");
				String name = results.getString("name");
				String dtype = results.getString("dtype");
				int width = results.getInt("width");
				int height = results.getInt("height");
				String cssClass = results.getString("cssClass");
				String cssStyle = results.getString("cssStyle");
				String text = results.getString("text");
				int order_type = results.getInt("order_type");
				int pageId = results.getInt("page");
				Widget widget = new Widget(id, name, width, height, cssClass, cssStyle, text, order_type, dtype,
						pageId);
				widgets.add(widget);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return widgets;
	}

	private final String findWidgetById = "SELECT * FROM Widget WHERE id=?";

	@Override
	public Widget findWidgetById(int widgetId) {
		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			ps = connection.prepareStatement(findWidgetById);
			ps.setInt(1, widgetId);
			ResultSet results = ps.executeQuery();
			while (results.next()) {
				int id = results.getInt("id");
				String name = results.getString("name");
				String dtype = results.getString("dtype");
				int width = results.getInt("width");
				int height = results.getInt("height");
				String cssClass = results.getString("cssClass");
				String cssStyle = results.getString("cssStyle");
				String text = results.getString("text");
				int order_type = results.getInt("order_type");
				int pageId = results.getInt("page");
				Widget widget = new Widget(id, name, width, height, cssClass, cssStyle, text, order_type, dtype,
						pageId);
				return widget;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	private final String findWidgetsForPage = "SELECT * FROM Widget WHERE page=?";
	@Override
	public Collection<Widget> findWidgetsForPage(int pageId) {
		Collection<Widget> widgets = new ArrayList<>();

		try {
			connection = edu.northeastern.cs5200.Connection.getConnection();
			ps = connection.prepareStatement(findWidgetsForPage);
			ps.setInt(1,pageId);
			ResultSet results = ps.executeQuery();
			while (results.next()) {
				int id = results.getInt("id");
				String name = results.getString("name");
				String dtype = results.getString("dtype");
				int width = results.getInt("width");
				int height = results.getInt("height");
				String cssClass = results.getString("cssClass");
				String cssStyle = results.getString("cssStyle");
				String text = results.getString("text");
				int order_type = results.getInt("order_type");
				int page = results.getInt("page");
				Widget widget = new Widget(id, name, width, height, cssClass, cssStyle, text, order_type, dtype,
						page);
				widgets.add(widget);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return widgets;
	
	}
	
	
	 private final String updateWidget = "UPDATE Widget SET `name`=?, width=?, height=?, cssClass=?, cssStyle=?, text=?, `order_type`=?, page=? WHERE id=?";
	@Override
	public int updateWidget(int widgetId, Widget widget) {
		 try {
	            connection = edu.northeastern.cs5200.Connection.getConnection();
	            ps = connection.prepareStatement(updateWidget);
	            ps.setString(1, widget.getName());
	            ps.setInt(2, widget.getWidth());
	            ps.setInt(3, widget.getHeight());
	            ps.setString(4, widget.getCssClass());
	            ps.setString(5, widget.getCssStyle());
	            ps.setString(6, widget.getText());
	            ps.setInt(7, widget.getOrder());
	            ps.setInt(8, widget.getPage().getId());
	            ps.setInt(9, widgetId);
	            return ps.executeUpdate();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return 0;
	}

	private final String deleteWidget = "Delete from Widget where id = ?";
	@Override
	public int deleteWidget(int widgetId) {
		// TODO Auto-generated method stub
		try {
            connection = edu.northeastern.cs5200.Connection.getConnection();
            ps = connection.prepareStatement(deleteWidget);
            ps.setInt(1, widgetId);
            return ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
	}

}
