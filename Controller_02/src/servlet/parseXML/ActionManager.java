package servlet.parseXML;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;






/**
* @author WaldenLu
* @data   2017年4月8日下午2:16:45
* 解析controller.xml文件
* 相当于action的name/class等属性都是通过我们写的controller.xml来写入的
* 定义一个result和action的map，对外的接口就是getAction() 用来返回action的信息。
*/
public class ActionManager {
	private Map<String, Action> actions;
	
	public ActionManager(){
		actions = new HashMap<String, Action>();
		Logger.getGlobal().info("开始解析。。。。。。。。。");
		this.paresAction();
		Logger.getGlobal().info("解析完成。。。。。。。。。");
	}
	
	private void paresAction(){
		try {
			//SAX解析 得到解析器并加载文件
			SAXReader saxReader = new SAXReader();
			InputStream inputStream = this.getClass().getResourceAsStream("/controller.xml");
			Document document = saxReader.read(inputStream);
			
			//获取根节点action-controller
			Element root = document.getRootElement();
			//得到所有的action子节点
			@SuppressWarnings("unchecked")
			List<Element> listAction = root.elements("action");
			//解析每个action节点
			for (Element ele_action:listAction) {
				Action action = new Action();
				//设置action的name域
				Element ele_name = ele_action.element("name");
				action.setName(ele_name.getText());
				//设置action的class域
				Element ele_class = ele_action.element("class");
				Clazz clazz = new Clazz();
				clazz.setName(ele_class.elementText("name"));
				clazz.setMethod(ele_class.elementText("method"));
				action.setClazz(clazz);
				//设置action的result域
				Map<String, Result> results = new HashMap<String, Result>();
				@SuppressWarnings("unchecked")
				Iterator<Element> iterator = ele_action.elementIterator("result");//返回子元素的迭代器
				while (iterator.hasNext()) {
					//解析每个result
					Element ele_resutl = iterator.next();
					Result res = new Result();
					res.setName(ele_resutl.elementText("name"));
					res.setType(ele_resutl.elementText("type"));
					res.setValue(ele_resutl.elementText("value"));
					//建立result的映射
					results.put(res.getName(), res);
				}
				action.setResults(results);
				
				//建立action的映射
				actions.put(action.getName(), action);
				
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
	
	public Action getAction(String name){
		if(name == null){
			System.out.println("action name wrong");
			return null;
		}else{
			Action action = actions.get(name);
			if (action == null) {
				System.out.println("不可识别的action请求");
			}
			return action;
		}
	}
	
}
