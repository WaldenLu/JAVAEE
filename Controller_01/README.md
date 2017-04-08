#### Controller_01
* WebContent文件夹下
    - /index.jsp在webContent文件夹下写index.jsp这个是登录的界面 包含一个表单
    - /pages/login_sucess.jsp 成功跳转
    - /pages/login_fail.jsp 失败跳转
    - /WEB-INF/web.xml 配置文件 //配置url映射
* Java Resorce
    - controller/LoginController.java 
    - userbean/UserBean.java
* 运行一个web项时，根据你配置的<welcome-file>来定义欢迎页，也就是直接输入"localhost:8080/Controller_01"的缺省情况下显示的页面。
* index.jsp中有一个form表单，按下submit按钮后，一个request被以post的方式发送到服务器这里的```action="login"```定义了拦截的方法为"login"，也就是处理的页面为"http://localhost:8080/Controller_01/login"
* 去web.xml中查找匹配的servlet发现"/login"对应的servlet的class是controller.LoginController,也就是说这个请求交给LoginController.java来处理。这个servlet中包含了两种情况下的转发，分别把结果转发到login_sucess.jsp和login\_fail.jsp页面。
* 需要特别注意的是web.xml中配置路径时，加不加"/"是很重要的问题，详见[路径](http://www.cnblogs.com/l1019/p/6511523.html)
* 在eclipse中调试javaweb时，servlet是缓存在服务器的，每次修改servlet之后需要clean一下，重新部署。而WebContent下的文件是实时更新的。