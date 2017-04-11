package servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;

/**
* @author WaldenLu
* @data   2017年4月8日下午7:49:15
*
*/
public class LoginAction {
	public Object login(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		Object uri = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("usrename+passwrod"+username+password);
		UserBean user = new UserBean(username, password);
		System.out.println(user.getUsername()+user.getPassword());
		if(user.Login() == false){
			uri = "fail";
		}else{
			//获取session对象,然后绑定对象、值到session对象上
			//用户登陆成功后服务器将用户的信息绑定到session对象上
			//之后你的每一个请求服务器都要去查看这个绑定的session是否存在
			request.getSession().setAttribute("user", user);
			uri = "success";
		}
		return uri;
	}
}
