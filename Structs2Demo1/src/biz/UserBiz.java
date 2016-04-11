package biz;

import java.util.List;

import  entity.Contact;

 

public interface UserBiz {
	public void regist(String username, String nickname, String pwd, String confirmPwd);
 
	public boolean login(String username,String password);
}
