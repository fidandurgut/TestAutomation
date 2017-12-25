package enums;

public enum LeftMenuItems {

	/**
	 * LeftMenuItems to be used in the test are added.
	 */
	DIGITAL_CAMERAS("Digital Cameras","a[href='https://www.amazon.com/Best-Sellers-Electronics-Digital-Cameras/zgbs/electronics/281052/ref=zg_bs_nav_e_2_502394']");

	private String link;
	private String title;

	LeftMenuItems(String title, String link ) {
		this.link = link;
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public String getTitle() {
		return title;
	}
}