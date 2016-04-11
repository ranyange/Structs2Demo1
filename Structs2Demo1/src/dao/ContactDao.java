package dao;

import java.util.List;

import  entity.Contact;

public interface ContactDao {
	public List<Contact> listAll();
	public void alterContact(Contact contact);
	public void addContact(Contact contact);
	public void deleteContactById(Integer id);
	
}
