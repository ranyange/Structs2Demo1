package action;

import biz.ContactBiz;
import biz.impl.ContactBizImpl;
import entity.Contact;
//����ͨ��;
public class DeleteContactAction {
	//ɾ����ϵ��action
	
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String del(){
		Integer id = getId();
		//ɾ��
		ContactBiz biz = new ContactBizImpl();
		biz.delContact(id);
		return "delete_able";
	}
	
}
