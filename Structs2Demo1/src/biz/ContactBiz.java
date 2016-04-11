package biz;

import java.util.List;

import  entity.Contact;

public interface ContactBiz {
	public void updateContact(Contact contact);
	public void insertContact(Contact contact);
	public void delContact(Integer id);
	public List<Contact> queryAllContact();
}

