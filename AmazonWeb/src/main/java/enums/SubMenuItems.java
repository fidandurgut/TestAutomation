package enums;

public enum SubMenuItems {

	/**
	 * SubMenuItems to be used in the test are added.
	 */
	BESTSELLERS("Best Sellers","ab:camera-subnav-flyout-content-2, camera-subnav-flyout-promo-2:generic-subnav-flyout");

	private String key;
	private String title;

	SubMenuItems( String title, String key) {
		this.key = key;
		this.title = title;
	}

	public String getKey() {
		return key;
	}

	public String getTitle() {
		return title;
	}
}