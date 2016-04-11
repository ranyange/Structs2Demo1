package action;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import biz.ContactBiz;
import biz.impl.ContactBizImpl;

import com.opensymphony.xwork2.ActionContext;

import entity.Contact;
public class AddContactAction {
	
	//添加联系人
	 
	 
	private String name;
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
	private Date birth;
	private Integer age;
	private String phone;
	private String zipCode;
	//
	public String add() throws UnsupportedEncodingException{
		//1.获取前端联系人: new String(name.getBytes("ISO-8859-1"),"utf-8");
		 Contact contact = new Contact(null,new String(getName().getBytes("ISO-8859-1"),"utf-8"),getBirth(),getAge(),getPhone(),getZipCode());
		 System.out.println(contact);
		ContactBiz biz = new ContactBizImpl();
		biz.insertContact( contact);
		return "add_able";
	}
	//测试成功;
}
