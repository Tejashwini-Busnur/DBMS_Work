package edu.northeastern.cs5200.models;

public class HtmlWidget extends Widget {
	
	private String html;
	
	public HtmlWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			Page page) {
		super(id, name, width, height, cssClass, cssStyle, text, order, page);
		// TODO Auto-generated constructor stub
	}
	
	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	

}
