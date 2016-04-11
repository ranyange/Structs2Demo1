package action;

import java.util.Map;

import com.google.code.kaptcha.Constants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import biz.UserBiz;
import biz.impl.UserBizImpl;

public class LoginAction extends ActionSupport{
	private String username;
	private String password;
	private String kaptcha;
	
	public String getKaptcha() {
		return kaptcha;
	}

	public void setKaptcha(String kaptcha) {
		this.kaptcha = kaptcha;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	//跳转到登录页面;
	 
	//jsp页面会跳转到这个页面;
	public String login(){ 
		//第一步,从session中拿到验证码,判断
		@SuppressWarnings("unchecked")
		Map<String,Object> sessionMap = (Map<String, Object>) ActionContext.getContext().get("session");
		String kapKey = Constants.KAPTCHA_SESSION_KEY;
		String kaptcha = (String) sessionMap.get(kapKey);
		if(!kapKey.equals(kaptcha)){
			sessionMap.put("kapError", "验证码错误");
		} 
		
		
		UserBiz biz = new UserBizImpl();
		
		
		String username = getUsername();
		
		try {
			boolean flag = biz.login(getUsername(), getPassword());
			Map<String,Object> loginSession = (Map<String,Object>)ActionContext.getContext().get("session");
			if(flag){
				//将登录信息存入session;
				loginSession.put("username", username);
				return "success";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "fail";
		}
			
	    return "fail";
	}
}
