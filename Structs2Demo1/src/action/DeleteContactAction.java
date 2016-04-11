package action;

import biz.ContactBiz;
import biz.impl.ContactBizImpl;
import entity.Contact;
//测试通过;
public class DeleteContactAction {
	//删除联系人action
	
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String del(){
		Integer id = getId();
		//删除
		ContactBiz biz = new ContactBizImpl();
		biz.delContact(id);
		return "delete_able";
	}
	
}
