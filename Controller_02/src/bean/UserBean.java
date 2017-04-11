package bean;
/**
* @author WaldenLu
* @data   2017年4月8日下午7:40:53
*
*/
public class UserBean {
	private static final String NAME="aaa";
	private static final String PASSWORD="aaa";
	private String username;
	private String password;
	public UserBean(String username, String password){
		this.username = username;
		this.password = password;
	}
	public UserBean(){
		
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
	
	public boolean Login(){
		if (NAME.equals(username)&&PASSWORD.equals(password))
			return true;
		else
			return false;
	}
	public boolean Register(){
		if(username!=""&&password!="")
			return true;
		else
			return false;
	}
}
