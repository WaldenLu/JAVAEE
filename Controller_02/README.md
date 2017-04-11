#### Controller_02
* WebContent
    - /index.jsp在webContent文件夹下写index.jsp这个是登录的界面 包含一个表单
    - /pages
        + login_sucess.jsp 成功跳转
        + login_fail.jsp 失败跳转
        + register_fail.jsp 
        + register_sucess.jsp 
    - /WEB-INF/web.xml 配置文件 //配置url映射
* Java Resorce
    - src
        + controller/LoginController.java 
        + bean/UserBean.java
        + servlet.action
            * /LoginAction.java 
            * /RegisterAction.java
        + servlet.controller/Controller.java *控制器* 
        + servlet.parseXML   *主要就是一个解析controller.xml功能，并提供了Action的封装* 
            * Action.java 
            * ActionManager.java
            * Clazz.java 
            * Result.java 
        + controller.xml *说明了在各个action下的处理策略：登录成功时是转发还是跳转到哪个页面。* 
         
###### 执行过程
按下登录按钮时，客户端向服务器发送uri: /Controller_02/login.scaction
解析actionName为 login
查找controller.xml文件中配置的classname为servlet.action.LoginAction

通过xml中配置的路径servlet.action.LoginAction 找到class 
得到这个class中的具体方法login
将接收到的requeste，response对象传到login方法 由login方法处理



    
