package edu.northeastern.cs5200.models;

public class HeadingWidget extends Widget {
	
	private int size;
	
	public HeadingWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text,
			int order, Page page) {
		super(id, name, width, height, cssClass, cssStyle, text, order, page);
		// TODO Auto-generated constructor stub
	}
	
	public HeadingWidget(String name, int width, int height, String cssClass, String cssStyle,
			String text, int order) {
		super(name, width, height, cssClass, cssStyle, text, order);
		this.dType = "heading";	
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
	

}
