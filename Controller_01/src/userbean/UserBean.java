package userbean;
/**
* @author ssscorch
* @data   
*
*/
public class UserBean {
	public boolean checkLogin(String name, String password){
/*		System.out.println("USERBEAN");
		System.out.println("name:"+name+"password"+password);*/
		
		return name.equals(password);//简单验证 用户名和密码相同
	}
}
