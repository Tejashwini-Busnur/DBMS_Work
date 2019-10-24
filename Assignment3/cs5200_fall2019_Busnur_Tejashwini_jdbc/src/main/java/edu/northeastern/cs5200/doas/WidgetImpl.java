package edu.northeastern.cs5200.doas;

import java.util.Collection;

import edu.northeastern.cs5200.models.Widget;

public interface WidgetImpl {
	
	void createWidgetForPage(int pageId, Widget widget);
	//inserts properties in widget instance parameter into the Widget table. The widget's pageId foreign key refer to Page table primary key id whose value is equal to the pageId parameter
	Collection<Widget> findAllWidgets();
	//returns all records from Widget table as a Collection of Widget instances
	Widget findWidgetById(int widgetId);
	//returns a record from Widget table whose id field is equal to the widgetId parameter
	Collection<Widget> findWidgetsForPage(int pageId);
	//returns all records from Widget table as a Collection of Widget instances whose pageId is equal to the pageId parameter
	int updateWidget(int widgetId, Widget widget);
	//updates record in Widget table whose id field is equal to widgetId parameter. New record field values are set to the values in the widget instance parameter
	int deleteWidget(int widgetId);
	//deletes record from Widget table whose id field is equal to widgetId parameter


}
