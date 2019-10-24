package edu.northeastern.cs5200.models;

public class YouTubeWidget extends Widget{
	
	
	private String url;
    private Boolean isShareable = false;
    private Boolean isExpandable = false;
    
    public YouTubeWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text,
			int order, Page page) {
		super(id, name, width, height, cssClass, cssStyle, text, order, page);
		// TODO Auto-generated constructor stub
	}

	public YouTubeWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text,
			int order, Page page, String url, Boolean isShareable, Boolean isExpandable) {
		super(id, name, width, height, cssClass, cssStyle, text, order, page);
		this.url = url;
		this.isShareable = isShareable;
		this.isExpandable = isExpandable;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getIsShareable() {
		return isShareable;
	}

	public void setIsShareable(Boolean isShareable) {
		this.isShareable = isShareable;
	}

	public Boolean getIsExpandable() {
		return isExpandable;
	}

	public void setIsExpandable(Boolean isExpandable) {
		this.isExpandable = isExpandable;
	}
    
    

}
