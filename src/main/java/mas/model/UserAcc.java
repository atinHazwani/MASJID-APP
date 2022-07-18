package mas.model;

public class UserAcc {
	private String userID;
	private String username;
	private String password;
	private String role;
	private Admin admin;
	private RegUser reguser;
	
	public UserAcc() {}
	
	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public RegUser getReguser() {
		return reguser;
	}

	public void setReguser(RegUser reguser) {
		this.reguser = reguser;
	}

	
}
