package action;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import biz.ContactBiz;
import biz.impl.ContactBizImpl;
import entity.Contact;

public class UpdateContactAction {
	//更新联系人信息
	private Integer id;
	private String name;
	private Date birth;
	private Integer age;
	private String phone;
	private String zipCode;
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String pos() throws UnsupportedEncodingException{
		Contact contact = new Contact(getId(),new String(getName().getBytes("ISO-8859-1"),"utf-8"),getBirth(),getAge(),getPhone(),getZipCode());
		ContactBiz biz = new ContactBizImpl();
		biz.updateContact(contact);
		return "update_able";
	}
}
