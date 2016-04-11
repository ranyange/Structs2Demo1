package action;

import java.util.List;
import java.util.Map;

import biz.ContactBiz;
import biz.impl.ContactBizImpl;

import com.opensymphony.xwork2.ActionContext;

import entity.Contact;

public class QueryAllContactAction {
	public String queryContact(){
		 
		ContactBiz contactBiz = new ContactBizImpl();
		List<Contact> ps = contactBiz.queryAllContact();
		
		Map<String ,Object> sessionMap = (Map<String ,Object>)ActionContext.getContext().get("session");
		sessionMap.put("ps", ps);
		return "query_able";
	}
}
