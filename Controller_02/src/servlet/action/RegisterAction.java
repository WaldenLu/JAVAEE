package servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;

/**
* @author WaldenLu
* @data   2017年4月8日下午7:49:26
*
*/
public class RegisterAction {
	public Object register(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		Object uri = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+password);
		
		UserBean user = new UserBean(username, password);
		if(user.Register() == true)
			uri = "success";
		else
			uri = "fail";
		
		return uri;
	}
}
