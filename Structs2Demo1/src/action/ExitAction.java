package action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class ExitAction {
	//注销已登录用户
	public String logout(){
		Map<String,Object> sessionMap = (Map<String,Object>)ActionContext.getContext().get("session");
		if(sessionMap.get("username")!=null){
			sessionMap.remove("username");
		}
		return "logout_able";
	}
}
