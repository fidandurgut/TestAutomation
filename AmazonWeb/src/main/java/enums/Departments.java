package enums;

public enum Departments {
	/**
	 * Departments to be used in the test are added.
	 */
	ELECTRONICS( "Electronics, Computers & Office", "span[data-nav-panelkey='ElectronicsComputersPanel']");

	private String css;
	private String title;

	Departments(String title, String css) {
		this.css = css;
		this.title = title;
	}

	public String getCss() {
		return css;
	}

	public String getTitle() {
		return title;
	}

}
