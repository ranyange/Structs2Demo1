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
	//��ת����¼ҳ��;
	 
	//jspҳ�����ת�����ҳ��;
	public String login(){
		//��һ��,��session���õ���֤��,�ж�
		@SuppressWarnings("unchecked")
		Map<String,Object> sessionMap = (Map<String, Object>) ActionContext.getContext().get("session");
		String kapKey = Constants.KAPTCHA_SESSION_KEY;
		String kaptcha = (String) sessionMap.get(kapKey);
		System.out.println(kaptcha);
		System.out.println(getKaptcha());
		UserBiz biz = new UserBizImpl();
		System.out.println(getUsername());
		System.out.println(getPassword());
		boolean flag = biz.login(getUsername(), getPassword());
		if(flag)
			return "success";
		return "fail";
	}
}