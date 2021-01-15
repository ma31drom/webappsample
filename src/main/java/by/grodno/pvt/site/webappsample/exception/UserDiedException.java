package by.grodno.pvt.site.webappsample.exception;

public class UserDiedException extends RuntimeException {

	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
