package servlet.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import servlet.parseXML.Action;
import servlet.parseXML.ActionManager;
import servlet.parseXML.Result;

/**
* @author ssscorch
* @data   
*
*/
public class Controller extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ActionManager actionManager;
	
	public void init() throws ServletException {
		//解析controller.xml文件
		Logger.getGlobal().info("init....");
		super.init();
		actionManager = new ActionManager();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			//获取请求uri，得到请求路径名称
			String uri = request.getRequestURI();
			System.out.println("uri: "+uri);
			//得到action name 即login或者register
			String actionName = uri.substring(uri.lastIndexOf("/")+1,uri.indexOf(".scaction"));
			System.out.println("actionName: " + actionName);
			
			//根据请求uri中得到的action name，得到类的名称、方法
			Action action = actionManager.getAction(actionName);
			if(action == null){System.out.println("action is null");}
			if(action == null){
				response.sendError(400);//400 Bad Request语义有误，当前请求无法被服务器理解
			} else {
				String className = action.getClazz().getName();
				System.out.println("得到xml文件中配置的classname为"+className);
				String method = action.getClazz().getMethod();
				System.out.println(method);
				
				//利用反射：由解析得到的类的名称创建对象
				Class<?> clazz = Class.forName(className);//Class.forName(param) 这是Class类中的一个静态方法 调用这个方法获得Object的类名
				System.out.println("通过反射找到class"+clazz);
				Object object = clazz.newInstance();//通过newInstance()方法创建对象
				// 由解析得到的方法名称找到对象中对应的方法
				//getDeclareMethod(name,class<?>....) 第一个参数是String类型的方法名，后面是这个方法的参数列表 用于定位这个方法
				//获得具体的方法 避免overload的干扰
				Method m = clazz.getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
				System.out.println("得到这个具体方法的名字为"+ m.getName());
				//m.invoke(object, request, response) 表示实现了方法m代表的方法 并传入参数obj,request,response
				String retrunFlag = (String) m.invoke(object, request, response);
				System.out.println(request+"  "+response+"  "+retrunFlag);
				//利用该标记，读取配置文件对应的result
				//Key:pages/login_success.jsp Value:servlet.parseXML.Result@4b2cd1fb
				//Key:pages/login_fail.jsp    Value:servlet.parseXML.Result@6766e01
		
				Result result = action.getResults().get(retrunFlag);
				
			/*   
			 * Map<String, Result> map = action.getResults();
			    Set<String> keys = map.keySet();
			    for(String key:keys){
			    	System.out.println(key+"-"+map.get(key));
			    }
			*/
			    /********************************************/
			/*
				Set<Entry<String, Result>> allSet=map.entrySet();
				Iterator<Map.Entry<String, Result>> iter=allSet.iterator();
				        while(iter.hasNext()){
				        Map.Entry<String, Result> me=iter.next();
				        System.out.println(me.getKey()+ "---------"+me.getValue());
				    }
				Result result = map.get(retrunFlag);
			*/
				
				
		
				System.out.println();
				if(result ==null){
					response.sendError(404);//404 Not Found请求失败，请求所希望得到的资源未被在服务器上发现。					
				} else {
					String type = result.getType();//类型
					String page = result.getValue();//页面
					System.out.println("type:"+type+"page:"+page);
					// 跳转页面
					//xml文件中定义了各个不同的类型（比如说重定向类型/转发类型）和这些类型对应的page 
					//当程序获取了type和page后，按照不同的type向page进行转发或者重定向操作
					
			        
					
					if("redirect".equals(type)){//重定向
						//发给客户端的响应，让客户端重新发送请求到"request.getContextPath() + "/" + page"页面
						response.sendRedirect(request.getContextPath() + "/" + page);
					}else if("forward".equals(type)){//请求转发
						//服务器的行为，客户端不知道，页面也不会发生跳转
						request.getRequestDispatcher(page).forward(request, response);
					  //request.getRequestDispatcher(page).forward(request, response);
					}else{
						System.out.println("跳转类型错误");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
