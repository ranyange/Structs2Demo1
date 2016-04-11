package action;

 
import biz.UserBiz;
import biz.impl.UserBizImpl;
import entity.User;

public class RegisterAction {
	//封装action 中 Contact属性类;
	private User user;
	//确认密码
	private String confirmPwd;
	public String getConfirmPwd() {
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

	//用户注册
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String signUp(){
		System.out.println(user);
		//注册成功
		//跳转到登录页面  (接受注册页面传来的用户名)
		UserBiz biz = new UserBizImpl();
		try {
			biz.regist(user.getUsername(), user.getNickname(), user.getPassword(), getConfirmPwd());
		} catch (Exception e) {
			//注册失败
			return "signUp_unable";
		}
		//注册成功
		return "signUp_able";
	}
}
