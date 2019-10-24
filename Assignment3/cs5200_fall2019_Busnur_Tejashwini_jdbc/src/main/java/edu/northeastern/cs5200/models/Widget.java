package edu.northeastern.cs5200.models;

public class Widget {

	private int id;
	private String name;
	private int width;
	private int height;
	private String cssClass;
	private String cssStyle;
	private String text;
	private int order;
	protected String dType;
    private int pageId;
	private Page page;

	public Widget(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			Page page) {
		super();
		this.id = id;
		this.name = name;
		this.width = width;
		this.height = height;
		this.cssClass = cssClass;
		this.cssStyle = cssStyle;
		this.text = text;
		this.order = order;
		this.page = page;
	}
	
	public Widget(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order) {
		super();
		this.id = id;
		this.name = name;
		this.width = width;
		this.height = height;
		this.cssClass = cssClass;
		this.cssStyle = cssStyle;
		this.text = text;
		this.order = order;
		
	}
	
	public Widget(String name,String dtype, int width, int height, String cssClass, String cssStyle, String text, int order) {
		super();
		this.name = name;
		this.width = width;
		this.height = height;
		this.cssClass = cssClass;
		this.cssStyle = cssStyle;
		this.text = text;
		this.order = order;
		this.dType = dtype;
		
	}
	

	public Widget(String name2, int width2, int height2, String cssClass2, String cssStyle2, String text2, int order2) {
		this.name = name2;
		this.width = width2;
		this.height = height2;
		this.cssClass = cssClass2;
		this.cssStyle = cssStyle2;
		this.text = text2;
		this.order = order2;
	}
	
	

	public Widget(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			String dType, int pageId) {
		super();
		this.id = id;
		this.name = name;
		this.width = width;
		this.height = height;
		this.cssClass = cssClass;
		this.cssStyle = cssStyle;
		this.text = text;
		this.order = order;
		this.dType = dType;
		this.setPageId(pageId);
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getCssStyle() {
		return cssStyle;
	}

	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

	public String getdType() {
		return dType;
	}

	public void setdType(String dType) {
		this.dType = dType;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
	
	
	
	

}
