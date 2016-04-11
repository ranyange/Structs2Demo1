package action;

 
import biz.UserBiz;
import biz.impl.UserBizImpl;
import entity.User;

public class RegisterAction {
	//��װaction �� Contact������;
	private User user;
	//ȷ������
	private String confirmPwd;
	public String getConfirmPwd() {
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

	//�û�ע��
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String signUp(){
		System.out.println(user);
		//ע��ɹ�
		//��ת����¼ҳ��  (����ע��ҳ�洫�����û���)
		UserBiz biz = new UserBizImpl();
		try {
			biz.regist(user.getUsername(), user.getNickname(), user.getPassword(), getConfirmPwd());
		} catch (Exception e) {
			//ע��ʧ��
			return "signUp_unable";
		}
		//ע��ɹ�
		return "signUp_able";
	}
}
