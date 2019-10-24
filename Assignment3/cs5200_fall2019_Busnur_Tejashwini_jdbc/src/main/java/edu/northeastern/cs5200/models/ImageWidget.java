package edu.northeastern.cs5200.models;

public class ImageWidget extends Widget{
	private String src;
	
	public ImageWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text,
			int order, Page page) {
		super(id, name, width, height, cssClass, cssStyle, text, order, page);
		// TODO Auto-generated constructor stub
	}

	public ImageWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text,
			int order, Page page, String src) {
		super(id, name, width, height, cssClass, cssStyle, text, order, page);
		this.src = src;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}
	
	

}
