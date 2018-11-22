package beans;

public class User {
	private String username;
	private String psd;
	
	public User() {
		this.username = "";
		this.psd = "";
	}
	
	public User(String username, String psd) {
		this.username = username;
		this.psd = psd;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPsd() {
		return psd;
	}
	public void setPsd(String psd) {
		this.psd = psd;
	}
	
	

}
