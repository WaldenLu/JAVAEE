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
    
