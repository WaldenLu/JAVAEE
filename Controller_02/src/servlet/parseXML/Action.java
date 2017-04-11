package servlet.parseXML;

import java.util.Map;

/**
* @author WaldenLu
* @data   
*
*/
public class Action {
	private String name;
	private Clazz clazz;
	private Map<String, Result> results;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Clazz getClazz() {
		return clazz;
	}
	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}
	public Map<String, Result> getResults() {
		return results;
	}
	public void setResults(Map<String, Result> results) {
		this.results = results;
	}
	
	
}
