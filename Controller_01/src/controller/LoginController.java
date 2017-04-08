package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userbean.UserBean;



/**
* @author ssscorch
* @data   
*
*/
public class LoginController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String name = request.getParameter("username");//getParameter() 得到客户端传来的信息
		String psword = request.getParameter("password");
		UserBean userBean = new UserBean();
		if(userBean.checkLogin(name, psword)){
			request.getRequestDispatcher("pages/login_success.jsp").forward(request, response);//请求转发 关于请求转发和请求重定向的内容见
		}else {																				   //http://www.cnblogs.com/linson0116/p/4277580.html
			request.getRequestDispatcher("pages/login_fail.jsp").forward(request, response);
		}
	}
	
}
