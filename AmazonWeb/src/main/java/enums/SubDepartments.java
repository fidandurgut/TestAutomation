package enums;

public enum SubDepartments {

	/**
	 * SubDepartments to be used in the test are added.
	 */
	CAMERA_PHOTO_VIDEO("Camera, Photo & Video",Departments.ELECTRONICS, "XxX");

	private String key;
	private Departments department;
	private String title;

	SubDepartments(String title, Departments department, String key) {
		this.key = key;
		this.department=department;
		this.title = title;
	}

	public String getKey() {
		return key;
	}
	public Departments getDepartment() {
		return department;
	}
	public String getTitle() {
		return title;
	}
	}